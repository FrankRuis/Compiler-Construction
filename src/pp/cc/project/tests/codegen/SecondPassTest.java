package pp.cc.project.tests.codegen;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.cc.project.Exceptions.ErrorListener;
import pp.cc.project.Exceptions.ParseException;
import pp.cc.project.Exceptions.RunException;
import pp.cc.project.codegen.FirstPass;
import pp.cc.project.codegen.FirstPassResult;
import pp.cc.project.codegen.SecondPass;
import pp.cc.project.dataobjects.Sprockell.*;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;
import pp.cc.project.utils.RuntimeUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Frank
 *
 * Test the sprockell program generation and compilation
 */
public class SecondPassTest {
    // The base directory for the correct Frartell files
    private final Path BASE_CORRECT;

    // Map containing the expected output for each sample program
    private Map<String, String> expectedOutput;

    /**
     * Constructor, initialize the path to the correct samples
     */
    public SecondPassTest() {
        expectedOutput = new HashMap<>();
        BASE_CORRECT = Paths.get(FileUtils.getProjPath("samples/correct"));

        // Fill the expectedOutput map with the expected output for each program
        expectedOutput.put("reverseArrayTest", "54321");
        expectedOutput.put("nestedIfWhileTest", "22");
        expectedOutput.put("swapTest", "21");
        expectedOutput.put("scopesTest", "0103");
    }

    @Test
    public void secondPassTest() {
        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_CORRECT).filter(Files::isRegularFile).forEach(file -> {
                // Get the parse tree
                ParseTree parseTree = null;
                try {
                    ErrorListener errorListener = new ErrorListener();
                    parseTree = ParseUtils.getParseTree(file.toFile(), errorListener);
                    errorListener.throwErrors();
                } catch (ParseException e) {
                    e.getErrors().forEach(System.err::println);
                    fail(String.format("%s was not parsed correctly.", file.getFileName()));
                }

                // Get the result of the type checking phase
                FirstPassResult firstPassResult = null;
                try {
                    firstPassResult = new FirstPass().check(parseTree);
                } catch (ParseException e) {
                    e.getErrors().forEach(System.err::println);
                }

                // Generate a sprockell program
                Program program = new SecondPass().generate(parseTree, firstPassResult);

                // Create a haskell file from the sprockell program
                File sprogram = FileUtils.createSprockellFile(program);


                // Compile the sprockell program and get the exit code
                int exitCode = RuntimeUtils.compileSprockell(sprogram, true);

                // Make sure the compilation was successful
                if (exitCode != 0) {
                    fail(String.format("%s did not compile successfully.", program.getName()));
                }


                // Run the compiled program and check the output if there is any
                try {
                    BufferedReader reader = RuntimeUtils.runSprockell(sprogram);

                    String line = null;
                    while (reader != null && (line = reader.readLine()) != null) {
                        System.out.printf("Output: %s%n", line);

                        // Make sure the output is as expected
                        assertEquals(line, expectedOutput.get(program.getName()));
                    }
                } catch (RunException e) {
                    fail(String.format("%s did not execute successfully.", program.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}