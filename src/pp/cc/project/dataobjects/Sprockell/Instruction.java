package pp.cc.project.dataobjects.Sprockell;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Frank
 *
 * A sprockell instruction
 */
public class Instruction {
    private Instr instruction; // The instruction type
    private List<Arg> args; // The instruction arguments
    private Optional<String> comment; // A haskell comment placed behind the instruction

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
        this.comment = Optional.empty();
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
        this.comment = Optional.of(comment);
    }

     /**
     * @return This instruction's comment
     */
    public String getComment() {
        return comment.orElse("");
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s",
                instruction.toString(),
                args.size() > 0 ? " " : "",
                String.join(" ", args.stream().map(Arg::toString).collect(Collectors.toList())),
                !comment.isPresent() ? "" : String.format(" --%s", comment.get()));
    }
}
