package Exceptions;

public class CannotBeNullException extends Exception{
    public CannotBeNullException(String field) {
        super("Bad request");
    }
}
