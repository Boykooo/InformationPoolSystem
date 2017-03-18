package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pool implements IBaseEntity {
    private int poolId;
    private String poolArea;
    private float poolDepth;
    private Collection<Track> trackList;

    @Id
    @Column(name = "pool_id", nullable = false)
    public int getPoolId() {
        return poolId;
    }

    public void setPoolId(int poolId) {
        this.poolId = poolId;
    }

    @Basic
    @Column(name = "pool_area", nullable = false, length = 20)
    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    @Basic
    @Column(name = "pool_depth", nullable = false, precision = 0)
    public float getPoolDepth() {
        return poolDepth;
    }

    public void setPoolDepth(float poolDepth) {
        this.poolDepth = poolDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pool pool = (Pool) o;

        if (poolId != pool.poolId) return false;
        if (Float.compare(pool.poolDepth, poolDepth) != 0) return false;
        if (poolArea != null ? !poolArea.equals(pool.poolArea) : pool.poolArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = poolId;
        result = 31 * result + (poolArea != null ? poolArea.hashCode() : 0);
        result = 31 * result + (poolDepth != +0.0f ? Float.floatToIntBits(poolDepth) : 0);
        return result;
    }

    @OneToMany(mappedBy = "pool")
    public Collection<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(Collection<Track> trackList) {
        this.trackList = trackList;
    }
}
