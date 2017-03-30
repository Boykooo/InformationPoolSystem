package dto;

import java.sql.Timestamp;

public class SessionDto implements IBaseDto {
    private Timestamp sessionTime;
    private Integer trackId;
    private Integer trackiD;
    private String userEmail;
    private Integer cost;

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

    public Integer getTrackiD() {
        return trackiD;
    }
    public void setTrackiD(Integer trackiD) {
        this.trackiD = trackiD;
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
