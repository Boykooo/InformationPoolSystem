package Entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class SessionPK implements Serializable {
    private Timestamp sessionTime;
    private Track track;

    //region GetSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Track getTrack() {
        return track;
    }
    public void setTrack(Track track) {
        this.track = track;
    }

    //endregion
}
