package Exceptions;

public class UpdateObjectNotExistException extends Exception {
    public UpdateObjectNotExistException() {
        super("The update object does not exist");
    }
}
