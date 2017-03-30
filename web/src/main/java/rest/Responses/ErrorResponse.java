package rest.Responses;

public class ErrorResponse extends AbstractResponse{
    public ErrorResponse(String status) {
        super("ERROR : " + status);
    }
}
