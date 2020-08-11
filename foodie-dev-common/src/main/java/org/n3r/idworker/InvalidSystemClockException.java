package org.n3r.idworker;

/**
 * @author code.rookie
 */
public class InvalidSystemClockException extends RuntimeException {
    public InvalidSystemClockException(String message) {
        super(message);
    }
}
