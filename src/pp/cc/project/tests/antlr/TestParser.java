package pp.cc.project.tests.antlr;

import org.junit.Test;
import pp.cc.project.utils.Exceptions.ErrorListener;
import pp.cc.project.utils.Exceptions.ParseException;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * @author Frank
 *
 * Test the parser on correct and incorrect Frartell programs
 */
public class TestParser {
    private final Path BASE_CORRECT;
    private final Path BASE_INCORRECT;

    /**
     * Constructor, set the paths to the folders with correct and incorrect programs
     */
    public TestParser() {
        BASE_CORRECT = Paths.get(FileUtils.getPath("pp/cc/project/samples/correct"));
        BASE_INCORRECT = Paths.get(FileUtils.getPath("pp/cc/project/samples/wrongparsing"));
    }

    @Test
    public void testCorrectFiles() {
        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_CORRECT).filter(Files::isRegularFile).forEach(file -> {
                // Get the parse tree
                try {
                    ErrorListener errorListener = new ErrorListener();
                    ParseUtils.getParseTree(file.toFile(), errorListener);
                    errorListener.throwErrors();
                } catch (ParseException e) {
                    e.getErrors().forEach(System.out::println);
                    fail(String.format("%s was not parsed correctly.", file.getFileName()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIncorrectFile() {
        // Test the file containing the parse problems
        File file = new File(BASE_INCORRECT + "/WrongParseTest.frart");

        // Get the parse tree
        try {
            ErrorListener errorListener = new ErrorListener();
            ParseUtils.getParseTree(file, errorListener);
            errorListener.throwErrors();
        } catch (ParseException e) {
            System.out.println("The following (expected) errors occurred: ");
            e.getErrors().forEach(System.out::println);

            // Make sure the right amount of errors occurred
            assertEquals(9, e.getErrors().size());

            // Expected
            return;
        }

        fail(String.format("%s was parsed correctly but should have failed.", file.getName()));
    }


}
