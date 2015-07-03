package pp.cc.project.utils.Exceptions;

import java.util.List;

/**
 * @author Frank
 *
 * Custom exception class for parse exceptions
 */
public class ParseException extends Exception {
    private List<String> errors;

    /**
     * Construct a parse exception with the given error message
     * @param messages The error messages
     */
    public ParseException(List<String> messages) {
        super(messages.toString());
        errors = messages;
    }

    /**
     * @return the list of errors
     */
    public List<String> getErrors() {
        return errors;
    }
}
