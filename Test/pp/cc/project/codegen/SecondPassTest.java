package pp.cc.project.codegen;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.cc.project.dataobjects.ParseException;
import pp.cc.project.dataobjects.Sprockell.*;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;
import pp.cc.project.utils.RuntimeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * @author Frank
 *
 * Test the sprockell program generation
 */
public class SecondPassTest {
    private final Path BASE_CORRECT;

    /**
     * Constructor, initialize the path to the correct samples
     */
    public SecondPassTest() {
        BASE_CORRECT = Paths.get(FileUtils.getPath("pp/cc/project/samples/correct"));
    }

    @Test
    public void secondPassTest() {
        try {
            // Go through all files in the correct files folder
            Files.walk(BASE_CORRECT).filter(Files::isRegularFile).forEach(file -> {
                // Get the parse tree
                ParseTree parseTree = ParseUtils.getParseTree(file.toFile());

                // Get the result of the type checking phase
                FirstPassResult firstPassResult = null;
                try {
                    firstPassResult = new FirstPass().check(parseTree);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Generate a sprockell program
                Program program = new SecondPass().generate(parseTree, firstPassResult);

                // Create a haskell file from the sprockell program
                File sprogram = FileUtils.createSprockellFile(program);

                // Compile the sprockell program and get the exit code
                int exitCode = RuntimeUtils.compileSprockell(sprogram, true);

                // Make sure the compilation was successful
                if (exitCode != 0) {
                    fail("The compilation did not finish successfully.");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}