package Entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "track_and_session", schema = "InformationPoolSystem", catalog = "mainDB")
@IdClass(TrackAndSessionPK.class)
public class TrackAndSession {
    private int trackId;
    private Timestamp sessionId;
    private Track track;
    private Session session;

    @Id
    @Column(name = "track_id", nullable = false)
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Id
    @Column(name = "session_id", nullable = false)
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

        TrackAndSession that = (TrackAndSession) o;

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

    @ManyToOne
    //@JoinColumn(name = "track_id", referencedColumnName = "track_id", nullable = false)
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @ManyToOne
    //@JoinColumn(name = "session_id", referencedColumnName = "session_time", nullable = false)
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
