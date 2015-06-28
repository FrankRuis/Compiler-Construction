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

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Frank
 */
public class SecondPassTest {
    @Test
    public void secondPassTest() throws Exception {
        // Get the file contents
        String file = FileUtils.readFile(new File(FileUtils.getProjPath("samples/correct/correct4.frart")));

        // Read the contents of the file and convert it to a token stream
        Lexer lexer = new FrartellLexer(new ANTLRInputStream(file));
        FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.program();

        // Get the result of the type checking phase
        FirstPassResult firstPassResult = new FirstPass().check(parseTree);

        Program program = new SecondPass().generate(parseTree, firstPassResult);

        System.out.println("Printing program:");
        System.out.println(program);
    }
}