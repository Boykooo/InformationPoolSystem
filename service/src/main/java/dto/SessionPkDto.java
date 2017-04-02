package dto;

import java.sql.Timestamp;

public class SessionPkDto {
    private Timestamp sessionTime;
    private TrackDto track;

    public SessionPkDto() {
    }

    public SessionPkDto(Timestamp sessionTime, TrackDto track) {
        this.sessionTime = sessionTime;
        this.track = track;
    }

    //region GetSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public TrackDto getTrack() {
        return track;
    }
    public void setTrack(TrackDto track) {
        this.track = track;
    }

    //endregion
}
