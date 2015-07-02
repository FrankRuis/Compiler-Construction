package pp.cc.project.tests.dataobjects.types;

import junit.framework.TestCase;
import pp.cc.project.dataobjects.type.*;

/**
 * @author Frank
 */
public class TestFrartellTypes extends TestCase {
    /**
     * Test the size methods of the Frartell types
     */
    public void testFrartellTypes() {
        Type intType = Type.INT;
        assertEquals(4, intType.size());

        Type boolType = Type.BOOL;
        assertEquals(4, boolType.size());

        Type noneType = new NoneType();
        assertEquals(0, noneType.size());

        Type stringType = new StringType(6);
        assertEquals(12, stringType.size());

        ArrayType arrayType = new ArrayType(4, intType);
        assertEquals(16, arrayType.size());
    }
}
