package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell data type
 */
public abstract class Type {
    /** An instance of {@link IntType} */
    public static final Type INT = new IntType();
    /** An instance of {@link BoolType} */
    public static final Type BOOL = new BoolType();

    private TypeKind kind; // This type's kind

    /**
     * Construct a type with the given kind
     * @param kind The type's {@link TypeKind}
     */
    public Type(TypeKind kind) {
        this.kind = kind;
    }

    /**
     * @return The type's {@link TypeKind}
     */
    public TypeKind getKind() {
        return kind;
    }

    /**
     * @return The size of this type in Bytes
     */
    public abstract int size();
}
