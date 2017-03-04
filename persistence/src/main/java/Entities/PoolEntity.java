package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pool", schema = "InformationPoolSystem", catalog = "mainDB")
public class PoolEntity {
    private int poolId;
    private String poolArea;
    private float poolDepth;
    private Collection<TrackEntity> trackList;

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

        PoolEntity that = (PoolEntity) o;

        if (poolId != that.poolId) return false;
        if (Float.compare(that.poolDepth, poolDepth) != 0) return false;
        if (poolArea != null ? !poolArea.equals(that.poolArea) : that.poolArea != null) return false;

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
    public Collection<TrackEntity> getTrackList() {
        return trackList;
    }

    public void setTrackList(Collection<TrackEntity> trackList) {
        this.trackList = trackList;
    }
}
