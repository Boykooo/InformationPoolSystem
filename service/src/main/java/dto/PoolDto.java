package dto;

import java.util.List;

public class PoolDto implements IBaseDto {

    private String name;
    private Double length;
    private Double width;
    private Double depth;
    private String type;
    private Boolean isWorking;
    private List<TrackDto> trackList;

    public PoolDto() {
    }

    public PoolDto(String name, Double length, Double width, Double depth, String type, Boolean isWorking) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.type = type;
        this.isWorking = isWorking;
    }

    //region GetSet

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

    public Boolean getIsWorking() {
        return isWorking;
    }
    public void setIsWorking(Boolean working) {
        isWorking = working;
    }

    public List<TrackDto> getTrackList() {
        return trackList;
    }
    public void setTrackList(List<TrackDto> trackList) {
        this.trackList = trackList;
    }

    //endregion
}
