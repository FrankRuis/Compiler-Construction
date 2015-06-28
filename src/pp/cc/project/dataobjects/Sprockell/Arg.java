package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
 * An argument for a Sprockell instruction
 */
public class Arg {
    private final Type type; // The type of argument

    /**
     * Construct an argument of the given type
     * @param type The argument type
     */
    protected Arg(Type type) {
        this.type = type;
    }

    /**
     * Returns the type of argument
     * @return This argument's type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Available argument types
     */
    public enum Type {
        /** A register */
        Reg,
        /** A constant (Int or Char) */
        Const,
        /** A jump target */
        Target,
        /** A computation operator */
        Operator,
        /** A memory address */
        MemAddr
    }
}
