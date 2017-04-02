package rest.Responses;

public class ErrorResponse extends CommonResponse {
    public ErrorResponse(String status) {
        super("ERROR : " + status);
    }
}
