package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

public class TrackAndSessionEntityPK implements Serializable {
    private int trackId;
    private Time sessionTime;

    @Column(name = "track_id", nullable = false)
    @Id
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Column(name = "session_time", nullable = false)
    @Id
    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Time sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackAndSessionEntityPK that = (TrackAndSessionEntityPK) o;

        if (trackId != that.trackId) return false;
        if (sessionTime != null ? !sessionTime.equals(that.sessionTime) : that.sessionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = 31 * result + (sessionTime != null ? sessionTime.hashCode() : 0);
        return result;
    }
}
