package rest.Responses;

public class AbstractResponse {
    private String status;

    public AbstractResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
