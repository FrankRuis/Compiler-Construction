package pp.cc.project.utils.Exceptions;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Frank
 *
 * Error listener for collecting Antlr errors
 */
public class ErrorListener extends BaseErrorListener {
    // List of errors
    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        this.errors.add(String.format("line %d:%d - %s", line,
                charPositionInLine,
                msg));
    }

    /**
     * Check if errors have occurred
     * @return True if there are one or more errors, else false
     */
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /**
     * @return The list of errors
     */
    public List<String> getErrors() {
        return this.errors;
    }

    /**
     * Throw a parse exception if errors occurred
     * @throws ParseException
     */
    public void throwErrors() throws ParseException {
        if (hasErrors()) {
            throw new ParseException(errors);
        }
    }
}
