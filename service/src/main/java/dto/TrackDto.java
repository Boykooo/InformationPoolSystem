package dto;

import java.util.List;

public class TrackDto implements IBaseDto {
    private Integer id;
    private Integer number;
    private String poolName;
    private List<SessionDto> sessionsList;

    //region GetSet

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPoolName() {
        return poolName;
    }
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public List<SessionDto> getSessionsList() {
        return sessionsList;
    }
    public void setSessionsList(List<SessionDto> sessionsList) {
        this.sessionsList = sessionsList;
    }

    //endregion
}