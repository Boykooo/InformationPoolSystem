package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class TrackAndSessionPK implements Serializable {

    @Id
    @Column(name = "track_id", nullable = false)
    private int trackId;
    @Column(name = "session_id", nullable = false)
    @Id
    private Timestamp sessionId;

    //region GetSet

    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Timestamp getSessionId() {
        return sessionId;
    }
    public void setSessionId(Timestamp sessionId) {
        this.sessionId = sessionId;
    }

    //endregion
}
