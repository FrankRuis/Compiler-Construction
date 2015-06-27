package pp.cc.project.codegen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.cc.project.antlr.FrartellBaseVisitor;
import pp.cc.project.antlr.FrartellParser;
import pp.cc.project.dataobjects.Sprockell.*;

/**
 * @author Frank
 *
 * Generation of a sprockell program
 */
public class SecondPass extends FrartellBaseVisitor<Instruction> {

    private Program program;
    private FirstPassResult result;
    private ParseTreeProperty<Register> registers;

    /**
     * Generate a sprockell program
     * @param tree The parse tree
     * @param result The result of the type checking phase
     * @return The sprockell program
     */
    public Program generate(ParseTree tree, FirstPassResult result) {
        this.result = result;
        program = new Program();
        registers = new ParseTreeProperty<>();

        tree.accept(this);

        return this.program;
    }

    @Override
    public Instruction visitDecl(@NotNull FrartellParser.DeclContext ctx) {
        Instruction exprResult = visit(ctx.expr());
        Register register = getReg(ctx.expr());
        int offset = result.getOffset(ctx.decltarget());

        System.out.println(offset);

        return super.visitDecl(ctx);
    }

    @Override
    public Instruction visitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx) {
        setReg(ctx, getReg(ctx.atom()));
        return super.visit(ctx.atom());
    }

    @Override
    public Instruction visitIntAtom(@NotNull FrartellParser.IntAtomContext ctx) {
        return emit(Instr.Const, new Constant(Integer.parseInt(ctx.INTEGER().getText())), getReg(ctx));
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
     * Get the register associated with the given parse tree node or create a new register if there are none yet
     * @param node The parse tree node
     * @return The associated register
     */
    public Register getReg(ParseTree node) {
        Register reg = registers.get(node);

        if (reg == null) {
            reg = new Register(Reg.RegA); //TODO Register allocation
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

    public int getOffset(ParseTree node) {
        return this.result.getOffset(node);
    }
}
