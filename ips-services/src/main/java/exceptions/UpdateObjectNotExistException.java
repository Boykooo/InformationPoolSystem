package exceptions;

public class UpdateObjectNotExistException extends Exception {
    public UpdateObjectNotExistException() {
        super("The fullUpdate object does not exist");
    }
}
