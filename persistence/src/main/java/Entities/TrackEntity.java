package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "track", schema = "InformationPoolSystem", catalog = "mainDB")
public class TrackEntity {
    private int trackId;
    private float length;
    private int poolId;
    private PoolEntity pool;
    private Collection<TrackAndSessionEntity> trackAndSessionList;

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

        TrackEntity that = (TrackEntity) o;

        if (trackId != that.trackId) return false;
        if (Float.compare(that.length, length) != 0) return false;
        if (poolId != that.poolId) return false;

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
    public PoolEntity getPool() {
        return pool;
    }

    public void setPool(PoolEntity pool) {
        this.pool = pool;
    }

    @OneToMany(mappedBy = "track")
    public Collection<TrackAndSessionEntity> getTrackAndSessionList() {
        return trackAndSessionList;
    }

    public void setTrackAndSessionList(Collection<TrackAndSessionEntity> trackAndSessionList) {
        this.trackAndSessionList = trackAndSessionList;
    }
}
