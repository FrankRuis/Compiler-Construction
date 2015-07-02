package pp.cc.project.dataobjects.sprockell;

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
    private Optional<String> name;

    /**
     * Construct a MemAddr object of the type Deref
     * @param register The register containing the memory address
     */
    public MemAddr(Register register) {
        super(Arg.Type.MemAddr);
        this.type = Type.Deref;
        this.register = Optional.of(register);
        this.name = Optional.empty();
        this.constant = Optional.empty();
    }

    /**
     * Construct a MemAddr object of the type Addr
     * @param constant The memory address
     */
    public MemAddr(Constant constant) {
        super(Arg.Type.MemAddr);
        this.type = Type.Addr;
        this.constant = Optional.of(constant);
        this.name = Optional.empty();
        this.register = Optional.empty();
    }

    /**
     * Construct a MemAddr object of the type Name
     * @param name The variable name for the memory address
     */
    public MemAddr(String name) {
        super(Arg.Type.MemAddr);
        this.type = Type.Name;
        this.constant = Optional.empty();
        this.register = Optional.empty();
        this.name = Optional.of(name);
    }

    /**
     * @return The address type
     */
    public Type getAddrType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("(%s%s)",
                name.isPresent() ? "" : type + " ",
                register.isPresent() ? register.get() : constant.isPresent() ? constant.get() : name.get());
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
        Deref,
        /**
         * Variable name, e.g. stdio or debugio
         */
        Name
    }
}
