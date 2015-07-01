package pp.cc.project.codegen;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.cc.project.dataobjects.ParseException;
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
    public void testCheck() throws Exception {
        // The file to test
        File file = new File(FileUtils.getProjPath("samples/incorrect/incorrect1.frart"));

        // Get the parse tree
        ParseTree parseTree = ParseUtils.getParseTree(file);

        // Create a FirstPass object to start the type checking phase
        FirstPass firstPass = new FirstPass();

        try {
            // Start the type checking phase
            firstPass.check(parseTree);
        } catch (ParseException e) {
            e.getErrors().stream().forEach(System.err::println);
            fail("Errors occurred while parsing.");
        }
    }
}