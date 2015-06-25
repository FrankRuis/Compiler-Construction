package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell Integer type
 */
public class IntType extends Type {
    /**
     * Construct an int type
     */
    public IntType() {
        super(TypeKind.INT);
    }

    /**
     * @return This type's size in bytes
     */
    public int size() {
        return Integer.BYTES;
    }

    @Override
    public String toString() {
        return "Integer";
    }
}
