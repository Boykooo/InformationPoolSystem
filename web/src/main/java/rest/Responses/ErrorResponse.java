package rest.Responses;

public class ErrorResponse extends AbstractResponse {
    public ErrorResponse(String message) {
        super("ERROR : " + message);
    }
}
