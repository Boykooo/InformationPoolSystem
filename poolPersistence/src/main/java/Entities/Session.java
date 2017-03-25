package Entities;

import com.sun.istack.internal.NotNull;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "session")
@Stateless
public class Session implements IBaseEntity{

    @Id
    @NotNull
    @Column(name = "session_time")
    private Timestamp sessionTime;
    @Basic
    @Column(name = "cost", nullable = false)
    private int cost;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "session")
    private List<TrackAndSession> trackSessionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (cost != session.cost) return false;
        if (sessionTime != null ? !sessionTime.equals(session.sessionTime) : session.sessionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cost;
        result = 31 * result + (sessionTime != null ? sessionTime.hashCode() : 0);
        return result;
    }

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

    public List<TrackAndSession> getTrackSessionList() {
        return trackSessionList;
    }
    public void setTrackSessionList(List<TrackAndSession> trackSessionList) {
        this.trackSessionList = trackSessionList;
    }

    //endregion
}