package Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Double length;

    @Basic
    @NotNull
    @Column(name = "width")
    private Double width;

    @Basic
    @NotNull
    @Column(name = "depth")
    private Double depth;

    @Basic
    @NotNull
    @Column(name = "type")
    private String type;

    @Basic
    @NotNull
    @Column(name = "isworking")
    private boolean isWorking;

    @Column(name = "picture")
    private byte[] picture;

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

    public Double getLength() {
        return length;
    }
    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }
    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getDepth() {
        return depth;
    }
    public void setDepth(Double depth) {
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

    public byte[] getPicture() {
        return picture;
    }
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    //endregion
}
