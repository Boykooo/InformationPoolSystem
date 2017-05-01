package jsf.Tables;

import controllers.TrackController;
import dto.TrackDto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("trackTableBean")
@ManagedBean
@RequestScoped
public class TrackTableBean {

    @EJB
    private TrackController controller;
    private List<TrackDto> tracks;

    @PostConstruct
    private void init(){
        tracks = controller.findAll();
    }

    public List<TrackDto> getTracks() {
        return tracks;
    }
    public void setTracks(List<TrackDto> tracks) {
        this.tracks = tracks;
    }

}
