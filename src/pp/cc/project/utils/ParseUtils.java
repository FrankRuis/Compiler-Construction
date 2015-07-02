package pp.cc.project.utils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.cc.project.antlr.FrartellLexer;
import pp.cc.project.antlr.FrartellParser;
import pp.cc.project.Exceptions.ErrorListener;

import java.io.File;

/**
 * @author Frank
 *
 * Class for easy access to functions for parsing frartell files
 */
public class ParseUtils {
    /**
     * Parse the given file and return the parse tree
     * @param file The file to parse
     * @return The resulting parse tree
     */
    public static ParseTree getParseTree(File file) {
        // Read the contents of the file
        String contents = FileUtils.readFile(file);

        // Convert the file contents to a token stream
        Lexer lexer = new FrartellLexer(new ANTLRInputStream(contents));
        FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));

        // Return the parse tree
        return parser.program();
    }

    /**
     * Parse the given file and return the parse tree, add the given error listener to the parser and lexer
     * @param file The file to parse
     * @param errorListener The error listener to add to the parser and lexer
     * @return The resulting parse tree
     */
    public static ParseTree getParseTree(File file, ErrorListener errorListener) {
        // Read the contents of the file
        String contents = FileUtils.readFile(file);

        // Convert the file contents to a token stream
        Lexer lexer = new FrartellLexer(new ANTLRInputStream(contents));
        lexer.addErrorListener(errorListener);
        FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));
        parser.addErrorListener(errorListener);

        // Return the parse tree
        return parser.program();
    }

    /**
     * Parse the string file and return the parse tree
     * @param s The string to parse
     * @return The resulting parse tree
     */
    public static ParseTree getParseTree(String s) {
        // Convert the file contents to a token stream
        Lexer lexer = new FrartellLexer(new ANTLRInputStream(s));
        FrartellParser parser = new FrartellParser(new CommonTokenStream(lexer));

        // Return the parse tree
        return parser.program();
    }
}
