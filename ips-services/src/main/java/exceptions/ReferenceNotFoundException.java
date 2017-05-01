package exceptions;

public class ReferenceNotFoundException extends Exception{
    public ReferenceNotFoundException(String field) {
        super("Reference to " + field + " not found");
    }
}
