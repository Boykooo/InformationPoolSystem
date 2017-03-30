package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pool")
public class Pool implements IBaseEntity {

    @Id
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic
    @NotNull
    @Column(name = "length")
    private String length;

    @Basic
    @NotNull
    @Column(name = "width")
    private String width;

    @Basic
    @NotNull
    @Column(name = "depth")
    private String depth;

    @Basic
    @NotNull
    @Column(name = "type")
    private String type;

    @Basic
    @NotNull
    @Column(name = "isworking")
    private boolean isWorking;

    @JsonIgnore
    @OneToMany(mappedBy = "pool")
    private List<Track> trackList;

    //region GetSet

    public List<Track> getTrackList() {
        return trackList;
    }
    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }
    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }
    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsWorking() {
        return isWorking;
    }
    public void setIsWorking(boolean working) {
        isWorking = working;
    }

    //endregion
}
