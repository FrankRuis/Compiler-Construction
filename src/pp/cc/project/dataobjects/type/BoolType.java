package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell Boolean type
 */
public class BoolType extends Type {
    /**
     * Construct a boolean type
     */
    public BoolType() {
        super(TypeKind.BOOL);
    }

    /**
     * @return This type's size in bytes
     */
    public int size() {
        return Integer.BYTES;
    }

    @Override
    public String toString() {
        return "Boolean";
    }
}
