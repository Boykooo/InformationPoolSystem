package Exceptions;

public class CannotBeNullException extends Exception{
    public CannotBeNullException(String field) {
        super("Required field " + field + " cannot be null");
    }
}
