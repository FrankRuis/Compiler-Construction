package pp.cc.project.tests.codegen;

import junit.framework.TestCase;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.cc.project.utils.Exceptions.ParseException;
import pp.cc.project.codegen.FirstPass;
import pp.cc.project.codegen.FirstPassResult;
import pp.cc.project.dataobjects.type.Type;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Frank
 *
 * Test the type checking phase
 */
public class FirstPassTest {
    @Test
    public void testWrongTypes() {
        // The file to test
        File file = new File(FileUtils.getProjPath("samples/incorrect/WrongTypesTest.frart"));

        // Get the parse tree
        ParseTree parseTree = ParseUtils.getParseTree(file);

        // Create a FirstPass object to start the type checking phase
        FirstPass firstPass = new FirstPass();

        // Start the type checking phase
        try {
            firstPass.check(parseTree);
        } catch (ParseException e) {
            System.out.println("The following (expected) errors occurred: ");
            e.getErrors().forEach(System.out::println);

            // Make sure the right amount of errors occurred
            assertEquals(21, e.getErrors().size());

            // Exception expected, skip the fail
            return;
        }

        fail(String.format("%s passed the type checking phase but shouldn't.", file.getName()));
    }

    @Test
    public void testCorrectTypes() {
        // The file to test
        File file = new File(FileUtils.getProjPath("samples/correct/ScopesTest.frart"));

        // Get the parse tree
        ParseTree parseTree = ParseUtils.getParseTree(file);

        // Create a FirstPass object to start the type checking phase
        FirstPass firstPass = new FirstPass();

        // Start the type checking phase
        try {
            FirstPassResult result = firstPass.check(parseTree);

            // Make sure the types and offsets are as expected

            // int x = 0;
            assertEquals(Type.INT, result.getType(parseTree.getChild(1)));
            assertEquals(0, result.getOffset(parseTree.getChild(1).getChild(1)));

            // x = 1
            assertEquals(Type.INT, result.getType(parseTree.getChild(2).getChild(0).getChild(1).getChild(0)));
            assertEquals(0, result.getOffset(parseTree.getChild(2).getChild(0).getChild(1).getChild(0)));

            // bool x = True;
            assertEquals(Type.BOOL, result.getType(parseTree.getChild(2).getChild(0).getChild(2).getChild(0)));
            assertEquals(4, result.getOffset(parseTree.getChild(2).getChild(0).getChild(2).getChild(1)));

            // x = False;
            assertEquals(Type.BOOL, result.getType(parseTree.getChild(2).getChild(0).getChild(3).getChild(0)));
            assertEquals(4, result.getOffset(parseTree.getChild(2).getChild(0).getChild(3).getChild(0)));

            // int y = 0;
            assertEquals(Type.INT, result.getType(parseTree.getChild(4)));
            assertEquals(4, result.getOffset(parseTree.getChild(4).getChild(1)));

            // x = 3;
            assertEquals(Type.INT, result.getType(parseTree.getChild(6).getChild(0)));
            assertEquals(0, result.getOffset(parseTree.getChild(6).getChild(0)));
        } catch (ParseException e) {
            e.getErrors().forEach(System.err::println);
            fail(String.format("%s did not pass the type checking phase", file.getName()));
        }
    }
}