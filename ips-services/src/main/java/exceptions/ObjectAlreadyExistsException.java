package exceptions;

public class ObjectAlreadyExistsException extends Exception {
    public ObjectAlreadyExistsException() {
        super("Object already exists");
    }
}
