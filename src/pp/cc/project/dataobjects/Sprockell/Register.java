package pp.cc.project.dataobjects.Sprockell;

import java.util.Arrays;
import java.util.List;

/**
 * @author Frank
 *
 * A Sprockell register
 */
public class Register extends Arg {

    private Reg name;
    private boolean available; // Whether or not this register is available for use

    /**
     * Construct a register with the given name
     * @param name The register name
     */
    public Register(Reg name) {
        super(Type.Reg);
        this.name = name;
        this.available = true;
    }

    /**
     * Get this register's name
     * @return The register name
     */
    public Reg getName() {
        return name;
    }

    /**
     * Check if the register is available
     * @return True if available, else false
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Set the register to available
     */
    public void setAvailable() {
        this.available = true;
    }

    /**
     * Set the register to unavailable
     */
    public void setUnavailable() {
        this.available = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Register)) {
            return false;
        }

        Register other = (Register) obj;
        return getName().equals(other.getName());
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    /**
     * Available Sprockell registers
     */
    public enum Reg {
        /**
         * User data register A
         */
        RegA,
        /**
         * User data register B
         */
        RegB,
        /**
         * User data register C
         */
        RegC,
        /**
         * User data register D
         */
        RegD,
        /**
         * User data register E
         */
        RegE,
        /**
         * Zero register, always contains zero
         */
        Zero,
        /**
         * Program counter, points to current instruction
         */
        PC,
        /**
         * Sprockell ID
         */
        SPID,
        /**
         * Stack pointer, points to top of stack
         */
        SP;

        /**
         * @return The user registers
         */
        public static List<Reg> userRegisters() {
            Reg[] regs = {RegA, RegB, RegC, RegD, RegE};
            return Arrays.asList(regs);
        }
    }
}
