package pp.cc.project.codegen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.cc.project.antlr.FrartellBaseVisitor;
import pp.cc.project.antlr.FrartellParser;
import pp.cc.project.dataobjects.Sprockell.Register.Reg;
import pp.cc.project.dataobjects.Sprockell.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Frank
 *
 * Generation of a sprockell program
 */
public class SecondPass extends FrartellBaseVisitor<Instruction> {

    /* Constant values for False and True expressions */
    private final Constant FALSE = new Constant(0);
    private final Constant TRUE = new Constant(1);

    private Program program; // The sprockell program object
    private FirstPassResult result; // The result of the type checking phase
    private ParseTreeProperty<Register> registers; // The registers mapped to parse tree nodes

    private Map<Reg, Register> userRegisters; // Map of the usable user registers

    /**
     * Initialize a SecondPass object
     */
    public SecondPass() {
        program = new Program();
        registers = new ParseTreeProperty<>();

        userRegisters = new LinkedHashMap<>();
        Reg.userRegisters().forEach(reg -> userRegisters.put(reg, new Register(reg)));
    }

    /**
     * Generate a sprockell program
     * @param tree The parse tree
     * @param result The result of the type checking phase
     * @return The sprockell program
     */
    public Program generate(ParseTree tree, FirstPassResult result) {
        this.result = result;

        // Call the visitor methods
        tree.accept(this);

        // Emit the end program instruction
        emit(Instr.EndProg);

        // Return the generated program
        return this.program;
    }

    @Override
    public Instruction visitProgname(@NotNull FrartellParser.PrognameContext ctx) {
        // Set the program name to the text of the ID node
        program.setName(ctx.ID().getText());
        return super.visitProgname(ctx);
    }

    @Override
    public Instruction visitBlockStat(@NotNull FrartellParser.BlockStatContext ctx) {
        // Visit the block
        return visit(ctx.block());
    }

    @Override
    public Instruction visitBlock(@NotNull FrartellParser.BlockContext ctx) {
        // If the block is not empty
        if (ctx.stat().size() > 0) {
            Instruction firstInstruction = visit(ctx.stat(0));

            // Visit all instructions
            ctx.stat().stream().filter(stat -> stat != ctx.stat(0)).forEach(this::visit);

            // Return the last visited instruction
            return firstInstruction;
        // Do nothing if the block is empty
        } else {
            return super.visitBlock(ctx);
        }
    }

    @Override
    public Instruction visitDeclStat(@NotNull FrartellParser.DeclStatContext ctx) {
        Instruction exprResult = null;

        // Variables may be initialized with no value
        if (ctx.expr() != null) {
            exprResult = visit(ctx.expr());

            // Get the register containing the result of the expression
            Register register = getReg(ctx.expr());
            // Get the offset of the variable
            Constant offset = getOffset(ctx.decltarget());

            // Store the expression result in the target variable
            emit(Instr.Store, register, new MemAddr(offset))
                    .setComment(String.format("store the contents of %s to variable %s",
                            register,
                            ctx.decltarget().getText()));

            // This register is no longer needed
            register.setAvailable();
        }

        return exprResult != null ? exprResult : super.visitDeclStat(ctx);
    }

    @Override
    public Instruction visitAssignStat(@NotNull FrartellParser.AssignStatContext ctx) {
        visit(ctx.expr());

        // Get the register containing the result of the expression
        Register register = getReg(ctx.expr());
        // Get the offset of the variable
        Constant offset = getOffset(ctx.target());

        // Store the result of the expression in the target variable
        Instruction storeInstr = emit(Instr.Store, register, new MemAddr(offset));
        storeInstr.setComment(String.format("store the contents of %s to variable %s",
                register,
                ctx.target().getText()));

        // This register is no longer needed
        register.setAvailable();

        return storeInstr;
    }

    @Override
    public Instruction visitWhileStat(@NotNull FrartellParser.WhileStatContext ctx) {
        // Set the loop position before the condition check
        int returnPos = program.size();
        Instruction conditionExpr = visit(ctx.expr());

        // Set the position for the jump instruction after the condition check
        int branchPos = program.size();

        Register register = getReg(ctx.expr());

        // Visit the while body
        visit(ctx.block());

        // Emit the jump to the return position
        Instruction jumpInstr = emit(Instr.Jump,
                new Target(Target.Type.Rel, new Constant(returnPos - program.size() - 1)));

        // Set the jump target to the instruction after the jump instruction
        int jumpTarget = instrNum(jumpInstr) - branchPos + 2;

        // Emit an inverted branch instruction
        emitAt(branchPos, Instr.InvBranch, register,
                new Target(Target.Type.Rel, new Constant(jumpTarget)))
                .setComment(String.format("relative jump of %d if %s contains the False value",
                        jumpTarget,
                        register));

        // This register is no longer needed
        register.setAvailable();

        return conditionExpr;
    }

    @Override
    public Instruction visitIfStat(@NotNull FrartellParser.IfStatContext ctx) {
        Instruction ifExprResult = visit(ctx.expr());

        // Set the position for the branch instruction to right after the if expression
        int branchPos = program.size();
        Register register = getReg(ctx.expr());
        setReg(ctx, register);
        boolean hasElse = ctx.block(1) != null;

        // This register is no longer needed
        register.setAvailable();

        // Visit the if block
        visit(ctx.block(0));

        // Set the position of the start else block
        int elsePos = program.size() + 1;

        // Visit the else block if there is one
        if (ctx.block(1) != null) {
            visit(ctx.block(1));
        }

        // If there is an else block, emit a branch to the first else block instruction
        if (hasElse) {
            // Get the instruction number of the first else instruction and add 2 for the instructions we will emit later
            int jumpTarget = elsePos + 1;

            // Insert the branch instruction to the left of the  first if block instruction
            emitAt(branchPos, Instr.InvBranch, register,
                    new Target(Target.Type.Rel, new Constant(jumpTarget - branchPos)))
                    .setComment(String.format("relative jump of %d if %s contains the False value",
                            jumpTarget - branchPos,
                            register));

            // Get the current end of the program and add 1 for the jump instruction that we will emit later
            jumpTarget = program.size() + 1;

            // Insert the jump instruction to the left of the first else block instruction
            emitAt(elsePos, Instr.Jump,
                    new Target(Target.Type.Rel, new Constant(jumpTarget - elsePos)));

        // Else, emit a branch to skip the if block
        } else {
            // Add 1 to the jump target because we will add the branch instruction later
            int jumpTarget = program.size() + 1;

            // Insert the branch instruction to the left of the  first if block instruction
            emitAt(branchPos, Instr.InvBranch, register,
                    new Target(Target.Type.Rel, new Constant(jumpTarget - branchPos)))
                    .setComment(String.format("relative jump of %d if %s contains the False value",
                    jumpTarget - branchPos,
                    register));
        }

        return ifExprResult;
    }

    @Override
    public Instruction visitTernExpr(@NotNull FrartellParser.TernExprContext ctx) {
        Instruction condExprResult = visit(ctx.expr(0));

        // Set the position for the branch instruction to right after the if expression
        int branchPos = program.size();
        Register register = getReg(ctx.expr(0));
        setReg(ctx, register);

        // This register is no longer needed
        register.setAvailable();

        // Visit the second expression and free its register
        visit(ctx.expr(1));
        Register register1 = getReg(ctx.expr(1));

        // Set the register of the third expression to that of the second expression
        setReg(ctx.expr(2), register1);

        // Set the position of the second expression
        int expr3Pos = program.size() + 1;

        // Visit the third expression and free its register
        visit(ctx.expr(2));

        // Add 1 to the expression position for the instruction we will emit later
        int jumpTarget = expr3Pos + 1;

        // Insert the branch instruction to the left of the second expression
        emitAt(branchPos, Instr.InvBranch, register,
                new Target(Target.Type.Rel, new Constant(jumpTarget - branchPos)))
                .setComment(String.format("relative jump of %d if %s contains the False value",
                        jumpTarget - branchPos,
                        register));

        // Get the current end of the program and add 1 for the jump instruction that we will emit later
        jumpTarget = program.size() + 1;

        // Insert the jump instruction to the left of the third expression
        emitAt(expr3Pos, Instr.Jump,
                new Target(Target.Type.Rel, new Constant(jumpTarget - expr3Pos)));

        // Set the register to that of expression 3
        setReg(ctx, getReg(ctx.expr(2)));

        return condExprResult;
    }

    @Override
    public Instruction visitAddExpr(@NotNull FrartellParser.AddExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit an instruction based on the type of operator
        switch (ctx.op.getType()) {
            case FrartellParser.MINUS:
                emit(Instr.Compute, operatorof(Operator.Type.Sub), register0, register1, register2);
                break;
            case FrartellParser.PLUS:
                emit(Instr.Compute, operatorof(Operator.Type.Add), register0, register1, register2);
                break;
            default:
                throw new RuntimeException(String.format("Unknown operator in add expression: %s", ctx.op.getText()));
        }

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitMultExpr(@NotNull FrartellParser.MultExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit an instruction based on the type of operator
        switch (ctx.op.getType()) {
            case FrartellParser.MOD:
                emit(Instr.Compute, operatorof(Operator.Type.Mod), register0, register1, register2);
                break;
            case FrartellParser.MULT:
                emit(Instr.Compute, operatorof(Operator.Type.Mul), register0, register1, register2);
                break;
            case FrartellParser.DIV:
                emit(Instr.Compute, operatorof(Operator.Type.Div), register0, register1, register2);
                break;
            default:
                throw new RuntimeException(String.format("Unknown operator in add expression: %s", ctx.op.getText()));
        }

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitPowExpr(@NotNull FrartellParser.PowExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit a compute instruction with the power operator
        emit(Instr.Compute, operatorof(Operator.Type.Pow), register0, register1, register2);

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitBoolExpr(@NotNull FrartellParser.BoolExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit an instruction based on the type of operator
        switch (ctx.op.getType()) {
            case FrartellParser.AND:
                emit(Instr.Compute, operatorof(Operator.Type.And), register0, register1, register2);
                break;
            case FrartellParser.OR:
                emit(Instr.Compute, operatorof(Operator.Type.Or), register0, register1, register2);
                break;
            default:
                throw new RuntimeException(String.format("Unknown operator in boolean expression: %s", ctx.op.getText()));
        }

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitCompExpr(@NotNull FrartellParser.CompExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit an instruction based on the type of operator
        switch (ctx.op.getType()) {
            case FrartellParser.LW:
                emit(Instr.Compute, operatorof(Operator.Type.Lt), register0, register1, register2);
                break;
            case FrartellParser.GR:
                emit(Instr.Compute, operatorof(Operator.Type.Gt), register0, register1, register2);
                break;
            case FrartellParser.LWEQ:
                emit(Instr.Compute, operatorof(Operator.Type.LtE), register0, register1, register2);
                break;
            case FrartellParser.GREQ:
                emit(Instr.Compute, operatorof(Operator.Type.GtE), register0, register1, register2);
                break;
            default:
                throw new RuntimeException(String.format("Unknown operator in boolean expression: %s", ctx.op.getText()));
        }

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitEqExpr(@NotNull FrartellParser.EqExprContext ctx) {
        // Get the lengths of the expression source intervals
        int sintlen0 = ctx.expr(0).getSourceInterval().length();
        int sintlen1 = ctx.expr(1).getSourceInterval().length();

        // Initialize the result of the first expression
        Instruction expr0Result;

        // Visit compound expressions first to avoid running out of registers
        if (sintlen0 > sintlen1) {
            expr0Result = visit(ctx.expr(0));
            visit(ctx.expr(1));
        } else {
            visit(ctx.expr(1));
            expr0Result = visit(ctx.expr(0));
        }

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(true, ctx);

        // Emit an instruction based on the type of operator
        switch (ctx.op.getType()) {
            case FrartellParser.EQ:
                emit(Instr.Compute, operatorof(Operator.Type.Equal), register0, register1, register2);
                break;
            case FrartellParser.NEQ:
                emit(Instr.Compute, operatorof(Operator.Type.NEq), register0, register1, register2);
                break;
            default:
                throw new RuntimeException(String.format("Unknown operator in boolean expression: %s", ctx.op.getText()));
        }

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return expr0Result;
    }

    @Override
    public Instruction visitUnaryMinExpr(@NotNull FrartellParser.UnaryMinExprContext ctx) {
        Instruction exprResult = visit(ctx.expr());

        // Assign registers for the expression and target and get the Zero register
        Register register0 = getReg(ctx, Reg.Zero);
        Register register1 = getReg(ctx.expr());
        Register register2 = getReg(true, ctx);

        // Subtract the result of the expression from the zero register and store it in the target register
        emit(Instr.Compute, operatorof(Operator.Type.Sub), register0, register1, register2);

        // These registers are no longer needed
        register0.setAvailable();
        register1.setAvailable();

        return exprResult;
    }

    @Override
    public Instruction visitNotExpr(@NotNull FrartellParser.NotExprContext ctx) {
        Instruction exprResult = visit(ctx.expr());

        // Get the register with the expression result and assign a register to this expression
        Register register0 = getReg(ctx.expr());
        Register register1 = getReg(true, ctx);

        // Load the value for True in register1
        emit(Instr.Const, TRUE, register1);

        // Xor the expression result with the True value and store it in this expression's register
        emit(Instr.Compute, operatorof(Operator.Type.Xor), register0, register1, register1);

        // We don't need this register anymore
        register0.setAvailable();

        return  exprResult;
    }

    @Override
    public Instruction visitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx) {
        // Visit the atom expression and set the register to that of the visited atom
        Instruction atomExpr = visit(ctx.atom());
        setReg(ctx, getReg(ctx.atom()));

        return atomExpr;
    }

    @Override
    public Instruction visitIntAtom(@NotNull FrartellParser.IntAtomContext ctx) {
        // Get the integer's value
        int num = Integer.parseInt(ctx.INTEGER().getText());

        // If the number is nonzero, load the number in an available register
        Register register;
        if (num != 0) {
            register = getReg(true, ctx);
            register.setUnavailable();

            return emit(Instr.Const, new Constant(num), register);

        // If the number is zero, we can use the zero register
        } else {
            getReg(ctx, Reg.Zero);

            return super.visitIntAtom(ctx);
        }
    }

    @Override
    public Instruction visitParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx) {
        // Visit the expression between parentheses
        Instruction parExpr = visit(ctx.expr());

        // Set the register to that of the expression between parentheses
        setReg(ctx, getReg(ctx.expr()));

        return parExpr;
    }

    @Override
    public Instruction visitIdAtom(@NotNull FrartellParser.IdAtomContext ctx) {
        // Assign a register
        Register register = getReg(true, ctx);
        register.setUnavailable();

        // Load the value of this ID to the register
        return emit(Instr.Load, new MemAddr(getOffset(ctx)), register);
    }

    @Override
    public Instruction visitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx) {
        // Assign a register
        Register register = getReg(true, ctx);

        // If the false token is present choose the False constant, else choose the True constant
        Constant bool = ctx.FALSE() != null ? FALSE : TRUE;
        register.setUnavailable();

        // Store the chosen boolean value in the register
        return emit(Instr.Const, bool, register);
    }

    /**
     * Construct an instruction and add it to the current program
     * @param type The type of instruction
     * @param args The instruction arguments
     * @return The generated instruction
     */
    public Instruction emit(Instr type, Arg... args) {
        Instruction instruction = new Instruction(type, args);
        program.add(instruction);

        return instruction;
    }

    /**
     * Construct an instruction and add it to the current program
     * @param position The position to place the instruction (shifts all other instructions to the right)
     * @param type The type of instruction
     * @param args The instruction arguments
     * @return The generated instruction
     */
    public Instruction emitAt(int position, Instr type, Arg... args) {
        Instruction instruction = new Instruction(type, args);
        program.add(position, instruction);

        return instruction;
    }

    /**
     * Get the register associated with the given parse tree node or create a new register if there are none yet
     * @param node The parse tree node
     * @return The associated register
     */
    public Register getReg(ParseTree node) {
        Register reg = registers.get(node);

        // If the given parse tree node has no associated register
        if (reg == null) {
            // Find an available register
            reg = userRegisters.values().stream()
                    .filter(Register::isAvailable)
                    .findFirst().get();

            // Throw an exception if there are no registers available
            if (reg == null) {
                throw new RuntimeException("Ran out of available registers.");
            }

            // Add the register to the register map
            registers.put(node, reg);
        }

        return reg;
    }

    /**
     * Get the register associated with the given parse tree node or create a new register if there are none yet<br>
     * Assigns a new register if the associated register is the Zero register.
     * @param node The parse tree node
     * @param target Whether or not this is a target register
     * @return The associated register
     */
    public Register getReg(boolean target, ParseTree node) {
        Register reg = registers.get(node);

        // If the given parse tree node has no associated register or the associated register is the Zero register
        if (reg == null || (target && reg.getName().equals(Reg.Zero))) {
            // Find an available register
            reg = userRegisters.values().stream()
                    .filter(Register::isAvailable)
                    .findFirst().get();

            // Throw an exception if there are no registers available
            if (reg == null) {
                throw new RuntimeException("Ran out of available registers.");
            }

            // Add the register to the register map
            registers.put(node, reg);
        }

        return reg;
    }

    /**
     * Get a specific register and associate it with the given parse tree node
     * @param node The parse tree node
     * @param regType The register type to get
     * @return The specified register
     */
    public Register getReg(ParseTree node, Reg regType) {
        Register register = new Register(regType);
        registers.put(node, register);

        return register;
    }

    /**
     * Associate a parse tree node with a register
     * @param node The parse tree node
     * @param reg The register
     */
    private void setReg(ParseTree node, Register reg) {
        this.registers.put(node, reg);
    }

    /**
     * Return the offset of the variable at the given parse tree node
     * @param node The parse tree node
     * @return The variable's offset
     */
    public Constant getOffset(ParseTree node) {
        return new Constant(this.result.getOffset(node));
    }

    /**
     * Get the instruction number of the given instruction
     * @param instruction The instruction
     * @return The instruction number
     */
    public int instrNum(Instruction instruction) {
        return program.instructionNumber(instruction);
    }

    /**
     * Create an operator of the given type
     * @param type The type of operator
     * @return The specified operator
     */
    public Operator operatorof(Operator.Type type) {
        return new Operator(type);
    }
}
