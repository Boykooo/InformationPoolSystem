package dto;

import java.sql.Timestamp;

public class SessionPkDto {
    private Timestamp sessionTime;
    private Integer trackId;

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

    //endregion
}
