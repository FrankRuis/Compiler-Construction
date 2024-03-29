package pp.cc.project.dataobjects.sprockell;

/**
 * @author Frank
 *
 * A Sprockell constant
 */
public class Constant extends Arg {
    private boolean isChar;
    private int value;

    /**
     * Construct a constant with value i
     * @param i The value of the constant
     */
    public Constant(int i) {
        super(Type.Const);
        this.isChar = false;
        this.value = i;
    }

    /**
     * Construct a constant with the value of the given character
     * @param c The character
     */
    public Constant(char c) {
        super(Type.Const);
        this.isChar = true;
        this.value = (int) c;
    }

    /**
     * @return this constant's value
     */
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return isChar ? String.format("(ord '%c')", (char) value) : String.format("(%d)", value);
    }
}
