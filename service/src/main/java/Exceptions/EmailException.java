package Exceptions;

public class EmailException extends Exception{

    public EmailException() {
        super("Email is invalid or already taken");
    }
}
