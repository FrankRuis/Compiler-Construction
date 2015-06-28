package pp.cc.project.utils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.cc.project.antlr.FrartellLexer;
import pp.cc.project.antlr.FrartellParser;

import java.io.File;

/**
 * @author Frank
 *
 * Class for easy access to functions for parsing frartell files
 */
public class ParseUtils {
    public static ParseTree getParseTree(File file) {
        // Read the contents of the file
        String contents = FileUtils.readFile(file);

        // Convert the file contents to a token stream
        Lexer lexer = new FrartellLexer(new ANTLRInputStream(contents));
        FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));

        // Return the parse tree
        return parser.program();
    }
}
