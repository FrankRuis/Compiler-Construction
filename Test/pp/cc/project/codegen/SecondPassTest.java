package pp.cc.project.codegen;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.cc.project.antlr.FrartellLexer;
import pp.cc.project.antlr.FrartellParser;
import pp.cc.project.dataobjects.Sprockell.*;
import pp.cc.project.utils.FileUtils;
import pp.cc.project.utils.ParseUtils;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Frank
 *
 * Test the sprockell program generation
 */
public class SecondPassTest {
    @Test
    public void secondPassTest() throws Exception {
        // Get the file contents
        File file = new File(FileUtils.getProjPath("samples/correct/correct6.frart"));

        // Get the parse tree
        ParseTree parseTree = ParseUtils.getParseTree(file);

        // Get the result of the type checking phase
        FirstPassResult firstPassResult = new FirstPass().check(parseTree);

        // Generate a sprockell program
        Program program = new SecondPass().generate(parseTree, firstPassResult);

        // Create a haskell file from the sprockell program
        FileUtils.createSprockellFile(program);
    }
}