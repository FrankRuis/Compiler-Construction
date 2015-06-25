package pp.cc.project.dataobjects;

import pp.cc.project.dataobjects.type.Type;

import java.util.LinkedList;

/**
 * @author Frank
 *
 * Class for opening and closing scopes.
 */
public class Scopes extends LinkedList<Scope> {
    /**
     * Constructs a list of scopes containing the outer scope
     */
    public Scopes() {
        super();
        this.addFirst(new Scope());
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
        Scope scope = new Scope();
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
     * @param id The variable's id
     * @param type The variable's type
     * @return True if the variable was added successfully, else false
     */
    public boolean put(String id, Type type) {
        return this.peekFirst().put(id, type);
    }

    /**
     * Get the type of a variable with the given id
     * @param id The variable's id
     * @return The type of the variable
     */
    public Type getType(String id) {
        return this.stream().filter(scope -> scope.contains(id))
                .findFirst().orElse(new Scope()).getType(id);
    }

    /**
     * Get the offset of the variable with the given id in the current scope
     * @param id The variable's id
     * @return The offset of the variable in the current scope
     */
    public int getOffset(String id) {
        return this.stream().filter(scope -> scope.contains(id))
                .findFirst().orElse(new Scope()).getOffset(id);
    }
}
