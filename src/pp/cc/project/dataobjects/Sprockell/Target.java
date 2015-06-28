package pp.cc.project.dataobjects.Sprockell;

import java.util.Optional;

/**
 * @author Frank
 *
 * Sprockell jump target
 */
public class Target extends Arg {

    private Type type;
    private Optional<Constant> value;
    private Optional<Register> register;

    /**
     * Construct a Target with the given type and value
     * @param type The type (Abs or Rel)
     * @param value The value
     */
    public Target(Type type, Constant value) {
        super(Arg.Type.Target);
        this.register = Optional.empty();
        this.value = Optional.of(value);
        // If the argument is a constant but the type is Ind, set the type to Abs
        this.type = !Type.Ind.equals(type) ? type : Type.Abs;
    }

    /**
     * Construct a Target with the given register
     * @param register
     */
    public Target(Register register) {
        super(Arg.Type.Target);
        this.value = Optional.empty();
        this.register = Optional.of(register);
        this.type = Type.Ind;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)",
                type,
                register.isPresent() ? register.get() : value.get());
    }

    /**
     * Target type
     */
    public enum Type {
        /**
         * Instruction number
         */
        Abs,
        /**
         * Relative instruction number
         */
        Rel,
        /**
         * Instruction number in register
         */
        Ind
    }
}
