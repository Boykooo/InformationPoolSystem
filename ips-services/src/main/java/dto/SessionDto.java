package dto;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

public class SessionDto implements IBaseDto {
    @NotNull
    private Timestamp sessionTime;
    @NotNull
    private TrackDto track;

    private String userEmail;
    @NotNull
    private Integer cost;

    public SessionDto() {
    }

    public SessionDto(Timestamp sessionTime, TrackDto track, String userEmail, Integer cost) {
        this.sessionTime = sessionTime;
        this.track = track;
        this.userEmail = userEmail;
        this.cost = cost;
    }

    //region GetSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }
    public void setSessionTime(Date sessionTime) {
        this.sessionTime = new Timestamp(sessionTime.getTime());
    }

    public TrackDto getTrack() {
        return track;
    }
    public void setTrack(TrackDto track) {
        this.track = track;
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
