package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell data type
 */
public abstract class Type {
    private TypeKind kind;

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
