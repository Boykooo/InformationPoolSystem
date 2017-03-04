package Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "session", schema = "InformationPoolSystem", catalog = "mainDB")
public class SessionEntity {
    private Time sessionTime;
    private int cost;
    private int userId;
    private UserEntity user;
    private Collection<TrackAndSessionEntity> trackAndSessionList;

    @Id
    @Column(name = "session_time", nullable = false)
    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Time sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Basic
    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionEntity that = (SessionEntity) o;

        if (cost != that.cost) return false;
        if (userId != that.userId) return false;
        if (sessionTime != null ? !sessionTime.equals(that.sessionTime) : that.sessionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionTime != null ? sessionTime.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + userId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "session")
    public Collection<TrackAndSessionEntity> getTrackAndSessionList() {
        return trackAndSessionList;
    }

    public void setTrackAndSessionList(Collection<TrackAndSessionEntity> trackAndSessionList) {
        this.trackAndSessionList = trackAndSessionList;
    }
}
