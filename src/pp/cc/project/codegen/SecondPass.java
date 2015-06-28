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
    public Instruction visitBlock(@NotNull FrartellParser.BlockContext ctx) {
        Instruction firstInstruction = visit(ctx.stat(0));

        // Visit all instructions
        ctx.stat().stream().filter(stat -> stat != ctx.stat(0)).forEach(this::visit);

        // Return the last visited instruction
        return firstInstruction;
    }

    @Override
    public Instruction visitDecl(@NotNull FrartellParser.DeclContext ctx) {
        Instruction exprResult = visit(ctx.expr());

        Register register = getReg(ctx.expr());
        Constant offset = getOffset(ctx.decltarget());

        emit(Instr.Store, register, new MemAddr(offset))
                .setComment(String.format("store the contents of %s to variable %s",
                        register,
                        ctx.decltarget().getText()));

        register.setAvailable();

        return exprResult;
    }

    @Override
    public Instruction visitAssignStat(@NotNull FrartellParser.AssignStatContext ctx) {
        Instruction exprResult = visit(ctx.expr());

        Register register = getReg(ctx.expr());
        Constant offset = getOffset(ctx.target());

        emit(Instr.Store, register, new MemAddr(offset))
                .setComment(String.format("store the contents of %s to variable %s",
                        register,
                        ctx.target().getText()));

        register.setAvailable();

        return exprResult;
    }

    @Override
    public Instruction visitIfStat(@NotNull FrartellParser.IfStatContext ctx) {
        Instruction ifExprResult = visit(ctx.expr());
        int branchPos = program.instructionNumber(ifExprResult) + 1;
        Register register = getReg(ctx.expr());
        setReg(ctx, register);
        boolean hasElse = ctx.block(1) != null;

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
                    new Target(Target.Type.Abs, new Constant(jumpTarget)))
                    .setComment(String.format("jump to instruction %d if %s contains the False value",
                            jumpTarget,
                            register));

            // Get the current end of the program and add 1 for the jump instruction that we will emit later
            jumpTarget = program.size() + 1;

            // Insert the jump instruction to the left of the first else block instruction
            emitAt(instrNum(firstElseInstr.get()), Instr.Jump,
                    new Target(Target.Type.Abs, new Constant(jumpTarget)));

        // Else, emit a branch to skip the if block
        } else {
            emitAt(branchPos, Instr.Branch, register,
                    new Target(Target.Type.Abs, new Constant(program.size())));
        }

        return ifExprResult;
    }

    @Override
    public Instruction visitAddExpr(@NotNull FrartellParser.AddExprContext ctx) {
        Instruction expr0Result = visit(ctx.expr(0));
        visit(ctx.expr(1));

        // Assign registers for the left expression, right expression and target
        Register register0 = getReg(ctx.expr(0));
        Register register1 = getReg(ctx.expr(1));
        Register register2 = getReg(ctx);

        // Emit an opcode based on the type of operator
        if (ctx.MINUS() != null) {
            emit(Instr.Compute, new Operator(Operator.Type.Sub), register0, register1, register2);
        } else if (ctx.PLUS() != null) {
            emit(Instr.Compute, new Operator(Operator.Type.Add), register0, register1, register2);
        } else {
            throw new RuntimeException("Unknown operator");
        }

        return expr0Result;
    }

    @Override
    public Instruction visitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx) {
        setReg(ctx, getReg(ctx.atom()));
        return super.visit(ctx.atom());
    }

    @Override
    public Instruction visitIntAtom(@NotNull FrartellParser.IntAtomContext ctx) {
        Register register = getReg(ctx);
        register.setUnavailable();

        return emit(Instr.Const, new Constant(Integer.parseInt(ctx.INTEGER().getText())), register);
    }

    @Override
    public Instruction visitParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx) {
        setReg(ctx, getReg(ctx.expr()));

        return visit(ctx.expr());
    }

    @Override
    public Instruction visitIdAtom(@NotNull FrartellParser.IdAtomContext ctx) {
        Register reg = getReg(ctx);
        reg.setUnavailable();

        return emit(Instr.Load, new MemAddr(getOffset(ctx)), reg);
    }

    @Override
    public Instruction visitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx) {
        Register reg = getReg(ctx);
        Constant bool = ctx.FALSE() != null ? FALSE : TRUE;
        reg.setUnavailable();

        return emit(Instr.Const, bool, reg);
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
}
