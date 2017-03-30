package Exceptions;

public class SessionAlreadyExistsException extends Exception {
    public SessionAlreadyExistsException() {
        super("Session already exists");
    }
}
