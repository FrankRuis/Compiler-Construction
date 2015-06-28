package pp.cc.project.dataobjects;

import pp.cc.project.dataobjects.type.Type;

import java.util.LinkedList;

/**
 * @author Frank
 *
 * Class for opening and closing scopes.
 */
public class Scopes extends LinkedList<Scope> {
    private int size; // Current scopes size in bytes

    /**
     * Constructs a list of scopes containing the outer scope
     */
    public Scopes() {
        super();
        this.size = 0;
        this.addFirst(new Scope(size));
    }

    /**
     * Check if a variable with the given id is declared in one of the open scopes
     * @param id The variable's id
     * @return True if the variable exists, else false
     */
    public boolean contains(String id) {
        return this.stream().anyMatch(scope -> scope.contains(id));
    }

    /**
     * Open a new scope
     */
    public Scope openScope() {
        Scope scope = new Scope(size);
        this.addFirst(scope);

        return scope;
    }

    /**
     * Close the current scope
     * @return True if the scope was closed successfully, else false
     */
    public boolean closeScope() {
        if (this.size() > 1) {
            this.removeFirst();

            return true;
        } else {
            return false;
        }
    }

    /**
     * Declare the given variable in the current scope
     * @param id The variable id
     * @param type The variable type
     * @return True if the variable was added successfully, else false
     */
    public boolean put(String id, Type type) {
        this.size += type.size();
        return this.peekFirst().put(id, type);
    }

    /**
     * Get the type of a variable with the given id
     * @param id The variable id
     * @return The type of the variable or NoneType if it does not exist
     */
    public Type getType(String id) {
        return this.stream().filter(scope -> scope.contains(id))
                .findFirst().orElse(new Scope(size)).getType(id);
    }

    /**
     * Get the offset of the variable with the given id in the current scope
     * @param id The variable id
     * @return The offset of the variable in the current scope or -1 if it does not exist
     */
    public int getOffset(String id) {
        return this.stream().filter(scope -> scope.contains(id))
                .findFirst().orElse(new Scope(size)).getOffset(id);
    }
}
