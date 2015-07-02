package pp.cc.project.tests.codegen;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.cc.project.Exceptions.ParseException;
import pp.cc.project.codegen.FirstPass;
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
            System.out.println("The following errors occurred: ");
            e.getErrors().forEach(System.out::println);

            // Make sure the right amount of errors occurred
            assert(e.getErrors().size() == 9);

            // Exception expected, skip the fail
            return;
        }

        fail(String.format("%s passed the type checking phase but shouldn't.", file.getName()));
    }
}