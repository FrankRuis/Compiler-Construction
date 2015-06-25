package pp.cc.project.antlr;

import static org.junit.Assert.fail;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Frank
 */
public class TestParser extends FrartellBaseListener {
    private final Path BASE_CORRECT;
    private final Path BASE_WRONG;

    private boolean errors;

    /**
     * Constructor
     */
    public TestParser() {
        // Get the path to the current working directory
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"));

        // IntelliJ's working directory is in PPFinalProject, eclipse's working directory is in PPFinalProject/src
        BASE_CORRECT = Paths.get(path.toString(), path.endsWith("PPFinalProject") ? "src/" : "",
                "pp/cc/project/samples/correct");
        BASE_WRONG = Paths.get(path.toString(), path.endsWith("PPFinalProject") ? "src/" : "",
                "pp/cc/project/samples/incorrect");
    }

    @Test
    public void testCorrectFiles() {
        errors = false;

        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_CORRECT).filter(Files::isRegularFile).forEach(file -> {
                // Read the contents of the file and convert it to a token stream
                Lexer lexer = new FrartellLexer(new ANTLRInputStream(readFile(file.toFile())));
                FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));
                ParseTree parseTree = parser.program();

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

                // Read the contents of the file and convert it to a token stream
                Lexer lexer = new FrartellLexer(new ANTLRInputStream(readFile(file.toFile())));
                FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));
                ParseTree parseTree = parser.program();

                // Walk the parse tree
                new ParseTreeWalker().walk(this, parseTree);

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

    /**
     * Read a file and return its contents.
     * @param file The file to read
     * @return The file contents, or an empty string if an error occurs
     */
    public String readFile(File file) {
        try {
            // Create a stringbuffer for the file contents
            StringBuilder builder = new StringBuilder();

            // Read all lines from the file
            Files.lines(file.toPath()).forEach(builder::append);

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
