package pp.cc.project.tests;

import junit.framework.TestSuite;
import junit.textui.TestRunner;
import pp.cc.project.tests.antlr.TestLexer;
import pp.cc.project.tests.antlr.TestParser;
import pp.cc.project.tests.codegen.FirstPassTest;
import pp.cc.project.tests.codegen.SecondPassTest;
import pp.cc.project.tests.codegen.TestScopes;
import pp.cc.project.tests.dataobjects.sprockell.TestSprockellObjects;
import pp.cc.project.tests.dataobjects.types.TestFrartellTypes;

/**
 * @author Frank
 *
 * Test suite for Frartell tests
 */
public class FrartellTestSuite {
    /**
     * Get a test suite containing all Frartell tests
     * @return The test suite
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(TestLexer.class);
        suite.addTestSuite(TestParser.class);
        suite.addTestSuite(FirstPassTest.class);
        suite.addTestSuite(SecondPassTest.class);
        suite.addTestSuite(TestScopes.class);
        suite.addTestSuite(TestSprockellObjects.class);
        suite.addTestSuite(TestFrartellTypes.class);

        return suite;
    }

    public static void main(String[] args) {
        // Run the test suite
        TestRunner.run(suite());
    }
}
