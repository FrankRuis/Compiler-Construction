package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell None type
 */
public class NoneType extends Type {

    /**
     * Construct a none type
     */
    public NoneType() {
        super(TypeKind.NONE);
    }

    /**
     * @return The size of this type in Bytes
     */
    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "None";
    }
}
