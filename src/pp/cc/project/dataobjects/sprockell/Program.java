package pp.cc.project.dataobjects.sprockell;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Frank
 *
 * A sprockell program
 */
public class Program extends LinkedList<Instruction> {
    private int sprockells;
    private String name;

    /**
     * Construct a program with one sprockell
     */
    public Program() {
        super();
        sprockells = 1;
        name = "prog";
    }

    /**
     * Construct a program with the given amount of sprockells
     * @param sprockells The amount of sprockells to deploy
     */
    public Program(int sprockells) {
        this.sprockells = sprockells;
        this.name = "prog";
    }

    /**
     * @return the program name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the program name
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The amount of sprockells
     */
    public int getSprockells() {
        return sprockells;
    }

    /**
     * Set the amount of sprockells to deploy
     * @param sprockells The amount of sprockells
     */
    public void setSprockells(int sprockells) {
        this.sprockells = sprockells;
    }

    /**
     * Get the instruction number of the given instruction
     * @param instruction The instruction
     * @return The instruction number
     */
    public int instructionNumber(Instruction instruction) {
        return indexOf(instruction);
    }

    @Override
    public String toString() {
        return String.format("import Sprockell.System\n\n" +
                        "%s = [ %s\n\t\t]\n\n" +
                        "main = run %d %s",
                name,
                String.join("\n\t\t, ", this.stream().map(Instruction::toString).collect(Collectors.toList())),
                sprockells,
                name);
    }
}
