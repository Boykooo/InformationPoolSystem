package Entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class SessionPK implements Serializable {
    private Timestamp sessionTime;
    private int trackId;

    //region GetSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    //endregion
}
