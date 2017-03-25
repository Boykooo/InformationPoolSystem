package Entities;

import com.sun.istack.internal.NotNull;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
@IdClass(SessionPK.class)
@Stateless
public class Session implements IBaseEntity{

    @Id
    @NotNull
    @Column(name = "time")
    private Timestamp sessionTime;

    @Id
    @NotNull
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    private int trackId;

    @NotNull
    @ManyToOne
    private Track track;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    @Basic
    @NotNull
    @Column(name = "cost")
    private int cost;

    //region getAndSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Track getTrack() {
        return track;
    }
    public void setTrack(Track track) {
        this.track = track;
    }

    //endregion
}