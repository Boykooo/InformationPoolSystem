package Entities;

import com.sun.istack.internal.NotNull;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.sql.Timestamp;

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
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

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

    //endregion
}