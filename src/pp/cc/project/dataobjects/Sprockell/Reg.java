package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
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
     * Program counter
     */
    PC,
    /**
     * Sprockell ID
     */
    SPID,
    /**
     * Stack pointer, points to top of stack
     */
    SP
}
