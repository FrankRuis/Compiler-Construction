package pp.cc.project.Exceptions;

/**
 * @author Frank
 *
 * Exception thrown when somehting goes wrong when running a sprockell program
 */
public class RunException extends Exception {
    /**
     * Construct a RunException with the given message
     * @param message The exception message
     */
    public RunException(String message) {
        super(message);
    }
}
