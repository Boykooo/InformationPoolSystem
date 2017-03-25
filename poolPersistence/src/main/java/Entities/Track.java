package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "track")
public class Track implements IBaseEntity{

    @Id
    @NotNull
    @Column(name = "track_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int trackId;
    @Basic
    @NotNull
    @Column(name = "length")
    private float length;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "pool_id", referencedColumnName = "pool_id")
    private Pool pool;
    @OneToMany(mappedBy = "track")
    private List<TrackAndSession> trackSessionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (trackId != track.trackId) return false;
        if (Float.compare(track.length, length) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = 31 * result + (length != +0.0f ? Float.floatToIntBits(length) : 0);
        return result;
    }

    //region GetSet

    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }

    public Pool getPool() {
        return pool;
    }
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public List<TrackAndSession> getTrackSessionList() {
        return trackSessionList;
    }
    public void setTrackSessionList(List<TrackAndSession> trackSessionList) {
        this.trackSessionList = trackSessionList;
    }

    //endregion
}
