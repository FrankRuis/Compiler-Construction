package pp.cc.project.dataobjects;

import java.util.List;

/**
 * @author Frank
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
