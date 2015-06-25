package pp.cc.project.dataobjects.type;

/**
 * @author Frank
 *
 * Frartell None type
 */
public class NoneType extends Type {

    /**
     * Constructor
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
}
