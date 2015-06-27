package pp.cc.project.dataobjects.Sprockell;

import java.util.Arrays;
import java.util.List;

/**
 * @author Frank
 *
 * A sprockell instruction
 */
public class Instruction {
    private Instr instruction;
    private List<Arg> args;
    private String comment;

    /**
     * Construct an instruction
     * @param instruction The instruction type
     * @param args The instruction's arguments
     */
    public Instruction(Instr instruction, Arg... args) {
        this(instruction, Arrays.asList(args));
    }

    /**
     * Construct an instruction
     * @param instruction The instruction type
     * @param args The instruction's arguments
     */
    public Instruction(Instr instruction, List<Arg> args) {
        this.instruction = instruction;
        this.args = args;
    }

    /**
     * @return The instruction type
     */
    public Instr getInstruction() {
        return instruction;
    }

    /**
     * @return The instruction arguments
     */
    public List<Arg> getArgs() {
        return args;
    }

    /**
     * Set this instruction's comment
     * @param comment The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

     /**
     * @return This instruction's comment
     */
    public String getComment() {
        return comment != null ? comment : "";
    }
}
