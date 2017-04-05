package Exceptions;

public class InvalidRequestException extends Exception {
    public InvalidRequestException() {
        super("Bad request");
    }
}
