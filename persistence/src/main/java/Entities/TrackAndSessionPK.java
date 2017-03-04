package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class TrackAndSessionPK implements Serializable {
    private int trackId;
    private Timestamp sessionId;

    @Column(name = "track_id", nullable = false)
    @Id
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Column(name = "session_id", nullable = false)
    @Id
    public Timestamp getSessionId() {
        return sessionId;
    }

    public void setSessionId(Timestamp sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackAndSessionPK that = (TrackAndSessionPK) o;

        if (trackId != that.trackId) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        return result;
    }
}
