package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
 * A Sprockell constant
 */
public class Constant extends Arg {
    private int value;

    /**
     * Construct a constant with value i
     * @param i The value of the constant
     */
    public Constant(int i) {
        super(Type.Const);
        this.value = i;
    }

    @Override
    public String toString() {
        return String.format("(%d)", value);
    }
}
