package rest.Responses;

public class CannotBeNullResponse extends AbstractResponse {
    public CannotBeNullResponse(String field) {
        super("Required field " + field + " cannot be null");
    }
}
