package pp.cc.project.antlr;

import static org.junit.Assert.fail;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Frank
 *
 * Test the parser on correct and incorrect Frartell programs
 */
public class TestParser extends FrartellBaseListener {
    private final Path BASE_CORRECT;
    private final Path BASE_WRONG;

    private boolean errors;

    /**
     * Constructor, set the paths to the folders with correct and incorrect programs
     */
    public TestParser() {
        BASE_CORRECT = Paths.get(FileUtils.getPath("pp/cc/project/samples/correct"));
        BASE_WRONG = Paths.get(FileUtils.getPath("pp/cc/project/samples/incorrect"));
    }

    @Test
    public void testCorrectFiles() {
        errors = false;

        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_CORRECT).filter(Files::isRegularFile).forEach(file -> {
                // Get the parse tree
                ParseTree parseTree = ParseUtils.getParseTree(file.toFile());

                // Walk the parse tree
                new ParseTreeWalker().walk(this, parseTree);
            });
        } catch (IOException e) {
            e.printStackTrace();
            errors = true;
        }

        // Fail the test if an error has occurred.
        if (errors) fail("Not all files were parsed correctly.");
    }

    @Test
    public void testWrongFiles() {
        errors = false;

        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_WRONG).filter(Files::isRegularFile).forEach(file -> {
                errors = false;

                // Get the parse tree
                ParseTree parseTree = ParseUtils.getParseTree(file.toFile());

                // Walk the parse tree
                new ParseTreeWalker().walk(this, parseTree);

                // Skip the call to fail if an error occurred
                if (errors) return;

                fail(String.format("%s was parsed correctly but should have failed.", file.getFileName()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // Set errors to true if something goes wrong.
        errors = true;
    }
}
