package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
 * Possible arguments for Sprockell instructions
 */
public class Arg {
    private final Type type;

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
        Reg,
        Const,
        Target,
        Operator,
        MemAddr
    }
}
