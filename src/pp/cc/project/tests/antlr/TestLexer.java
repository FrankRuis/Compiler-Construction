package pp.cc.project.tests.antlr;

import static org.junit.Assert.fail;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import pp.cc.project.antlr.FrartellLexer;

import java.io.*;
import java.util.List;

/**
 * @author Frank
 *
 * Test the lexer on several strings of possible tokens
 */
public class TestLexer {
    @Test
    public void testLexer() {
        try {
            assert (yields(scan("int x = 0;"), FrartellLexer.INT, FrartellLexer.ID,
                    FrartellLexer.ASSIGN, FrartellLexer.INTEGER, FrartellLexer.SEMCOL));
            assert(yields(scan("True true False false"), FrartellLexer.TRUE, FrartellLexer.ID,
                    FrartellLexer.FALSE, FrartellLexer.ID));
            assert(yields(scan("whi leif var_X \"String\""), FrartellLexer.ID, FrartellLexer.ID,
                    FrartellLexer.ID, FrartellLexer.STRING));
            assert(yields(scan("01234x123_5hX"), FrartellLexer.INTEGER, FrartellLexer.INTEGER, FrartellLexer.ID));
            assert(yields(scan("if while else print return"), FrartellLexer.IF, FrartellLexer.WHILE, FrartellLexer.ELSE,
                    FrartellLexer.PRINT, FrartellLexer.RETURN));


            wrong("@unknown symbol");
            wrong("'Single quote string'");
            wrong("\"Unclosed string");

            correct("while if { } else True False x");
            correct("var_X 7841");
            correct("aA_2134_asd321_;");
            correct("(a) ? (b + c) : (2 * d);");
            correct("[\"a\",\"b\"]");
        } catch (Exception e) {
            fail("Failed to parse a string that should be parsed correctly.");
        }

    }

    /**
     * Check if the lexer returns the expected token types
     * @param tokens The list of tokens generated by the lexer
     * @param expected The expected tokens
     * @return True if all expected tokens match, else false
     */
    public boolean yields(List<? extends Token> tokens, int... expected) {
        try {
            return tokens.stream().allMatch(token -> token.getType() == expected[tokens.indexOf(token)])
                    && tokens.size() == expected.length;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Test a if a correct string does not throw any errors.
     * @param string The string to parse
     */
    public void correct(String string) {
        try {
            scan(string);
        } catch (Exception e) {
            fail(String.format("%s should be accepted but wasn't.", string));
        }
    }

    /**
     * Test if a wrong string throws an error.
     * @param string The string to parse
     */
    public void wrong(String string) {
        try {
            scan(string);
            fail(String.format("%s should be rejected but wasn't.", string));
        } catch (Exception e) {
            // Exception expected
        }
    }

    /**
     * Scan the given string for tokens
     * @param string The string to scan
     * @return The resulting list of tokens
     */
    public List<? extends Token> scan(String string) throws Exception {
        // Redirect errors to a new output stream
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err, true));

        CharStream charStream = new ANTLRInputStream(string);
        Lexer lexer = new FrartellLexer(charStream);
        List<? extends Token> result = lexer.getAllTokens();

        // Set error output to the default
        System.setErr(System.err);

        // Throw an exception if something went wrong while parsing
        if (err.size() > 0) {
            throw new Exception("Failed to parse the whole string.");
        }

        return result;
    }
}