package dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class SessionDto implements IBaseDto {
    @NotNull
    private Timestamp sessionTime;
    @NotNull
    private Integer trackId;

    private String userEmail;
    @NotNull
    private Integer cost;

    public SessionDto() {
    }

    public SessionDto(Timestamp sessionTime, Integer trackId, String userEmail, Integer cost) {
        this.sessionTime = sessionTime;
        this.trackId = trackId;
        this.userEmail = userEmail;
        this.cost = cost;
    }

    //region GetSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Integer getTrackId() {
        return trackId;
    }
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getCost() {
        return cost;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    //endregion
}
