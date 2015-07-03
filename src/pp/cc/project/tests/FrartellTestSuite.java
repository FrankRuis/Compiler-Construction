package pp.cc.project.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
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
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSprockellObjects.class,
        TestFrartellTypes.class,
        TestScopes.class,
        TestLexer.class,
        TestParser.class,
        FirstPassTest.class,
        SecondPassTest.class
})
public class FrartellTestSuite {
    // Test suite should be runnable with the above annotations
}
