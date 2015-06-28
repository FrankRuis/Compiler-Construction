package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
 * Sprockell operator
 */
public class Operator extends Arg {
    private Type type;

    /**
     * Construct an operator with the given type
     * @param type The operator type
     */
    public Operator(Type type) {
        super(Arg.Type.Operator);
        this.type = type;
    }

    /**
     * @return this operator's type
     */
    public Type getOperatorType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    /**
     * Operator type
     */
    public enum Type {
        Add,
        Sub,
        Mul,
        Div,
        Mod,
        Equal,
        NEq,
        Gt,
        GtE,
        Lt,
        LtE,
        And,
        Or,
        Xor,
        LShift,
        RShift
    }
}
