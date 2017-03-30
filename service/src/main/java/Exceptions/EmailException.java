package Exceptions;

public class EmailException extends Exception{

    public EmailException() {
        super("Pool name is already taken");
    }
}
