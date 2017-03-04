package Entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "track_and_session", schema = "InformationPoolSystem", catalog = "mainDB")
@IdClass(TrackAndSessionEntityPK.class)
public class TrackAndSessionEntity {
    private int trackId;
    private Time sessionTime;
    private TrackEntity track;
    private SessionEntity session;

    @Id
    @Column(name = "track_id", nullable = false)
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Id
    @Column(name = "session_time", nullable = false)
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

        TrackAndSessionEntity that = (TrackAndSessionEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "track_id", nullable = false)
    public TrackEntity getTrack() {
        return track;
    }

    public void setTrack(TrackEntity track) {
        this.track = track;
    }

    @ManyToOne
    @JoinColumn(name = "session_time", referencedColumnName = "session_time", nullable = false)
    public SessionEntity getSession() {
        return session;
    }

    public void setSession(SessionEntity session) {
        this.session = session;
    }
}
