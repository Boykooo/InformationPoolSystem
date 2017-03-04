package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Track {
    private int trackId;
    private float length;
    private int poolId;
    private Pool pool;
    private Collection<TrackAndSession> trackSessionList;

    @Id
    @Column(name = "track_id", nullable = false)
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Basic
    @Column(name = "length", nullable = false, precision = 0)
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Basic
    @Column(name = "pool_id", nullable = false)
    public int getPoolId() {
        return poolId;
    }

    public void setPoolId(int poolId) {
        this.poolId = poolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (trackId != track.trackId) return false;
        if (Float.compare(track.length, length) != 0) return false;
        if (poolId != track.poolId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = 31 * result + (length != +0.0f ? Float.floatToIntBits(length) : 0);
        result = 31 * result + poolId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pool_id", referencedColumnName = "pool_id", nullable = false)
    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    @OneToMany(mappedBy = "track")
    public Collection<TrackAndSession> getTrackSessionList() {
        return trackSessionList;
    }

    public void setTrackSessionList(Collection<TrackAndSession> trackSessionList) {
        this.trackSessionList = trackSessionList;
    }
}
