package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell String type
 */
public class StringType extends Type {
    private int length;

    /**
     * Construct a string type with the given length
     * @param length The length of the string
     */
    public StringType(int length) {
        super(TypeKind.STRING);
        this.length = length;
    }

    /**
     * @return This type's size in bytes
     */
    public int size() {
        return Character.BYTES * length;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof StringType);
    }

    @Override
    public String toString() {
        return "String";
    }
}
