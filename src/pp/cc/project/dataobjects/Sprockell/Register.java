package pp.cc.project.dataobjects.Sprockell;

/**
 * @author Frank
 *
 * Class for a Sprockell register
 */
public class Register extends Arg {

    private Reg name;

    public Register(Reg name) {
        super(Type.Reg);
        this.name = name;
    }

    /**
     * Get this register's name
     * @return The register name
     */
    public Reg getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Register)) {
            return false;
        }

        Register other = (Register) obj;
        if (!getName().equals(other.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}
