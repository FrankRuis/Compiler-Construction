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
import java.util.Optional;

/**
 * @author Frank
 *
 * Generation of a sprockell program
 */
public class SecondPass extends FrartellBaseVisitor<Instruction> {

    // Constant values for False and True expressions
    private final Constant FALSE = new Constant(0);
    private final Constant TRUE = new Constant(1);

    private Program program;
    private FirstPassResult result;
    private ParseTreeProperty<Register> registers;

    private Map<Reg, Register> userRegisters;

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

        tree.accept(this);

        emit(Instr.EndProg);

        return this.program;
    }

    @Override
    public Instruction visitProgname(@NotNull FrartellParser.PrognameContext ctx) {
        program.setName(ctx.ID().getText());
        return super.visitProgname(ctx);
    }

    @Override
    public Instruction visitBlockStat(@NotNull FrartellParser.BlockStatContext ctx) {
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
        emit(Instr.Jump, new Target(Target.Type.Abs, new Constant(returnPos)));

        // Set the jump target to the next instruction
        int jumpTarget = program.size() + 1;

        // Emit an inverted branch instruction
        emitAt(branchPos, Instr.InvBranch, register,
                new Target(Target.Type.Abs, new Constant(jumpTarget)))
                .setComment(String.format("jump to instruction %d if %s contains the False value",
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

        // Visit the blocks and store the result of the else block in an optional (Optional because blocks may be empty)
        visit(ctx.block(0));
        Optional<Instruction> firstElseInstr = hasElse ?
                Optional.of(visit(ctx.block(1))) : Optional.empty();

        // If there is an else block, emit a branch to the first else block instruction
        if (firstElseInstr.isPresent()) {
            // Get the instruction number of the first else instruction and add 2 for the instructions we will emit later
            int jumpTarget = instrNum(firstElseInstr.get()) + 2;

            // Insert the branch instruction to the left of the  first if block instruction
            emitAt(branchPos, Instr.InvBranch, register,
                    new Target(Target.Type.Rel, new Constant(jumpTarget - branchPos)))
                    .setComment(String.format("jump to instruction %d if %s contains the False value",
                            jumpTarget,
                            register));

            // Get the current end of the program and add 1 for the jump instruction that we will emit later
            jumpTarget = program.size() + 1;

            // Insert the jump instruction to the left of the first else block instruction
            emitAt(instrNum(firstElseInstr.get()), Instr.Jump,
                    new Target(Target.Type.Rel, new Constant(jumpTarget - instrNum(firstElseInstr.get()))));

        // Else, emit a branch to skip the if block
        } else {
            // Add 1 to the jump target because we will add the branch instruction later
            int jumpTarget = program.size() + 1;

            emitAt(branchPos, Instr.InvBranch, register,
                    new Target(Target.Type.Abs, new Constant(jumpTarget)))
                    .setComment(String.format("jump to instruction %d if %s contains the False value",
                    jumpTarget,
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

        // Visit the expressions
        visit(ctx.expr(1));
        Instruction expr2Result = visit(ctx.expr(2));

        // Get the instruction number of the second expression and add 2 for the instructions we will emit later
        int jumpTarget = instrNum(expr2Result) + 2;

        // Insert the branch instruction to the left of the  first expression
        emitAt(branchPos, Instr.InvBranch, register,
                new Target(Target.Type.Abs, new Constant(jumpTarget)))
                .setComment(String.format("jump to instruction %d if %s contains the False value",
                        jumpTarget,
                        register));

        // Get the current end of the program and add 1 for the jump instruction that we will emit later
        jumpTarget = program.size() + 1;

        // Insert the jump instruction to the left of the first else block instruction
        emitAt(instrNum(expr2Result), Instr.Jump,
                new Target(Target.Type.Abs, new Constant(jumpTarget)));

        setReg(ctx, getReg(ctx.expr(2)));

        return condExprResult;
    }

    @Override
    public Instruction visitAddExpr(@NotNull FrartellParser.AddExprContext ctx) {
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

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
        Register register1 = getReg(ctx);

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
        setReg(ctx, getReg(ctx.expr()));

        return visit(ctx.expr());
    }

    @Override
    public Instruction visitIdAtom(@NotNull FrartellParser.IdAtomContext ctx) {
        Register register = getReg(true, ctx);
        register.setUnavailable();

        return emit(Instr.Load, new MemAddr(getOffset(ctx)), register);
    }

    @Override
    public Instruction visitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx) {
        Register register = getReg(true, ctx);
        Constant bool = ctx.FALSE() != null ? FALSE : TRUE;
        register.setUnavailable();

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

        if (reg == null) {
            // Find an available register or get RegA if none are available
            reg = userRegisters.values().stream()
                    .filter(Register::isAvailable)
                    .findFirst().orElse(userRegisters.get(Reg.RegA));
            registers.put(node, reg);
        }

        return reg;
    }

    /**
     * Get the register associated with the given parse tree node or create a new register if there are none yet
     * @param node The parse tree node
     * @param target Whether or not this is a target register
     * @return The associated register
     */
    public Register getReg(boolean target, ParseTree node) {
        Register reg = registers.get(node);

        // Target registers should not be the Zero register
        if (reg == null || (target && reg.getName().equals(Reg.Zero))) {
            // Find an available register or get RegA if none are available
            reg = userRegisters.values().stream()
                    .filter(Register::isAvailable)
                    .findFirst().orElse(userRegisters.get(Reg.RegA));
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
