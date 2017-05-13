package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PoolDto implements IBaseDto {

    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    private Double length;
    @NotNull
    private Double width;
    @NotNull
    private Double depth;
    @NotNull
    private String type;
    @NotNull
    private Boolean isWorking;

    private String pathToPicture;

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

    public void setPathToPicture(byte[] pathToPicture) {
        // Вызывается из сервисов

//        try {
//            this.pathToPicture = ImageIO.read(new ByteArrayInputStream(pathToPicture));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void setPicture(String image) {
        this.pathToPicture = image;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public String getImage() {

        return pathToPicture;

//        if (pathToPicture != null) {
//
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            int w = pathToPicture.getWidth(null);
//            int h = pathToPicture.getHeight(null);
//
//            int scale = 1;
//            BufferedImage bufferedImage = new BufferedImage(w * scale, h * scale,
//                    BufferedImage.TYPE_INT_ARGB);
//            Graphics g = bufferedImage.getGraphics();
//
//            g.drawImage(pathToPicture, 0, 0, w * scale, h * scale, null);
//
//            ImageIO.write(pathToPicture, "jpg", bos);
//
//            StreamedContent content = new DefaultStreamedContent(new ByteArrayInputStream(
//                    bos.toByteArray()), "image/jpg");
//
//            return  content;
//        }
    }
}
