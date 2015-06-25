package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell Array type
 */
public class ArrayType extends Type {
    private int length;
    private Type elemType; // The type of the array elements

    /**
     * Construct an array type with the given length and element type
     * @param length The length of the array
     * @param elemType The type of the array's elements
     */
    public ArrayType(int length, Type elemType) {
        super(TypeKind.ARRAY);
        this.length = length;
        this.elemType = elemType;
    }

    /**
     * @return This type's size in bytes
     */
    public int size() {
        return length * elemType.size();
    }

    @Override
    public String toString() {
        return String.format("Array[%d] of %s", length, elemType);
    }
}
