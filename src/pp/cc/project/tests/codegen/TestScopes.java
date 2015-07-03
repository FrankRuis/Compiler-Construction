package pp.cc.project.tests.codegen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pp.cc.project.codegen.Scopes;
import pp.cc.project.dataobjects.type.*;

/**
 * @author Frank
 *
 * Test opening and closing of scopes.
 * Check the assignment of types to variables,
 * and check overwriting variables from outer scopes in inner scopes.
 */
public class TestScopes {
    @Test
    public void testScopes() {
        Scopes scopes = new Scopes();
        assert(scopes.size() == 1);

        // Add 'a' to the current scope as an Integer
        scopes.put("a", new IntType());
        assert(scopes.getType("a") instanceof IntType);
        assertEquals(0, scopes.getOffset("a"));

        // Add 'b' to the current scope as an Integer Array with a size of 4
        scopes.put("b", new ArrayType(4, new IntType()));
        assert(scopes.getType("b") instanceof ArrayType);
        assertEquals(4, scopes.getOffset("b"));

        // Add 'c' to the current scope as a Boolean
        scopes.put("c", new BoolType());
        assert(scopes.getType("c") instanceof BoolType);
        assertEquals(20, scopes.getOffset("c"));

        // Open two new scopes
        scopes.openScope();
        scopes.openScope();
        assert(scopes.getType("a") instanceof IntType);
        assertEquals(0, scopes.getOffset("a"));
        assert(scopes.getType("b") instanceof ArrayType);
        assertEquals(4, scopes.getOffset("b"));
        assert(scopes.getType("c") instanceof BoolType);
        assertEquals(20, scopes.getOffset("c"));

        // Add 'd' to the current scope as an Integer
        scopes.put("d", new IntType());
        assert(scopes.getType("d") instanceof IntType);
        assertEquals(24, scopes.getOffset("d"));

        // Overwrite 'a' with a String type
        scopes.put("a", new StringType(5));
        assert(scopes.getType("a") instanceof StringType);

        // Close the current scope
        scopes.closeScope();
        assert(scopes.getType("a") instanceof IntType);
        assert(scopes.getType("d") instanceof NoneType);

        // Try closing the outer scope
        assert(scopes.closeScope());
        assert(!scopes.closeScope());
        assert(scopes.getType("a") instanceof IntType);
    }
}
