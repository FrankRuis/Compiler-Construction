package pp.cc.project.dataobjects.Sprockell;

import java.util.Optional;

/**
 * @author Frank
 *
 * A Sprockell MemAddr
 */
public class MemAddr extends Arg {
    private Type type;
    private Optional<Register> register;
    private Optional<Constant> constant;

    /**
     * Construct a MemAddr object of the type Deref
     * @param register The register containing the memory address
     */
    public MemAddr(Register register) {
        super(Arg.Type.MemAddr);
        this.type = Type.Deref;
        this.register = Optional.of(register);
        constant = Optional.empty();
    }

    /**
     * Construct a MemAddr object of the type Addr
     * @param constant The memory address
     */
    public MemAddr(Constant constant) {
        super(Arg.Type.MemAddr);
        this.type = Type.Addr;
        this.constant = Optional.of(constant);
        register = Optional.empty();
    }

    /**
     * @return The address type
     */
    public Type getAddrType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)",
                type,
                register.isPresent() ? register.get() : constant.get());
    }

    /**
     * Type of MemAddr
     */
    public enum Type {
        /**
         * Local or shared memory address (Addr Int)
         */
        Addr,
        /**
         * Local or shared memory address stored at the given register (Deref Register)
         */
        Deref
    }
}
