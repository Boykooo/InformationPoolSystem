package rest.Responses;

public class CommonResponse {
    private String status;

    public CommonResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
