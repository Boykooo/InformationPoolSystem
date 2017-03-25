package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "track")
public class Track implements IBaseEntity{

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Basic
    @NotNull
    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "pool_id", referencedColumnName = "id")
    private Pool pool;

    @OneToMany(mappedBy = "track")
    private List<Session> sessionsList;

    //region GetSet

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Pool getPool() {
        return pool;
    }
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Session> getSessionsList() {
        return sessionsList;
    }
    public void setSessionsList(List<Session> sessionsList) {
        this.sessionsList = sessionsList;
    }

    //endregion
}
