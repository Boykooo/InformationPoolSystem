package services;

import Entities.Session;
import dto.SessionDto;
import dto.SessionPkDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SessionService implements IService<SessionDto, SessionPkDto> {

    @EJB
    private TrackService trackService;

    public SessionDto findById(SessionPkDto key) {
        return null;
    }

    public List<SessionDto> findAll() {
        return null;
    }

    public void insert(SessionDto sessionDto) {

    }

    public void update(SessionDto sessionDto) {

    }

    public boolean delete(SessionPkDto key) {
        return false;
    }

    private Session convertToEntity(SessionDto dto){
        Session session = new Session();
        session.setCost(dto.getCost());
        session.setSessionTime(dto.getSessionTime());
        session.setTrackId(dto.getTrackId());
        //session.setTrack(trackService trackService.findById(dto.getTrackId()));
        return null;
    }

    private SessionDto convertToDto(Session dto){
        return null;
    }
}
