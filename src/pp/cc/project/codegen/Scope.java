package pp.cc.project.codegen;

import pp.cc.project.dataobjects.type.NoneType;
import pp.cc.project.dataobjects.type.Type;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Frank
 *
 * Contains type information of a single scope.
 */
public class Scope {
    private int size; // Current scope size in bytes
    private final Map<String, Type> types; // Map of declared variables and their type
    private final Map<String, Integer> offsets; // Map of declared variables and their offset in the current scope

    /**
     * Constructs an empty scope
     */
    public Scope() {
        this.size = 0;
        this.types = new LinkedHashMap<>();
        this.offsets = new LinkedHashMap<>();
    }

    /**
     * Constructs an empty scope with the given offset
     * @param offset The initial offset
     */
    public Scope(int offset) {
        this.size = offset;
        this.types = new LinkedHashMap<>();
        this.offsets = new LinkedHashMap<>();
    }

    /**
     * Check if the given variable is declared in this scope
     * @param id The variable id
     * @return True is the variable is declared, else false
     */
    public boolean contains(String id) {
        return this.types.containsKey(id);
    }

    /**
     * Declare the given variable in this scope
     * @param id The variable id
     * @param type The variable type
     * @return True if the variable was added successfully, else false
     */
    public boolean put(String id, Type type) {
        boolean result = !this.types.containsKey(id);

        // If the variable was not yet added
        if (result) {
            // Add the type and offset of the variable
            this.types.put(id, type);
            this.offsets.put(id, this.size);

            // Increase the scope size
            this.size += type.size();
        }

        return result;
    }

    /**
     * Get the type of a variable with the given id
     * @param id The variable id
     * @return The type of the variable
     */
    public Type getType(String id) {
        return this.types.getOrDefault(id, new NoneType());
    }

    /**
     * Get the offset of the variable with the given id in the current scope
     * @param id The variable id
     * @return The offset of the variable in the current scope
     */
    public Integer getOffset(String id) {
        return this.offsets.get(id) != null ? this.offsets.get(id) : -1;
    }
}
