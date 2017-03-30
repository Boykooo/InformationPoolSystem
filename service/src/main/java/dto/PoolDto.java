package dto;

import java.util.List;

public class PoolDto implements IBaseDto {

    private String name;
    private String length;
    private String width;
    private String depth;
    private String type;
    private boolean isWorking;
    private List<TrackDto> trackList;

    //region GetSet

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

    public boolean isWorking() {
        return isWorking;
    }
    public void setWorking(boolean working) {
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
