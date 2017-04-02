package services;

import Entities.Session;
import Entities.SessionPK;
import Entities.Track;
import Entities.User;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import dao.SessionDao;
import dto.SessionDto;
import dto.SessionPkDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class SessionService implements IService<SessionDto, SessionPkDto> {

    @EJB
    private SessionDao dao;
    @EJB
    private TrackService trackService;

    public SessionDto findById(SessionPkDto key) {
        return convertToDto(dao.findById(convertToSessionPK(key)));
    }

    public List<SessionDto> findAll() {
        List<Session> sessions = dao.findAll();
        List<SessionDto> sessionsDto = new ArrayList<SessionDto>();
        for (int i = 0; i < sessionsDto.size(); i++) {
            sessionsDto.set(i, convertToDto(sessions.get(i)));
        }

        return sessionsDto;
    }

    public void insert(SessionDto dto) throws ObjectAlreadyExistsException {
        if (dao.findById(createSessionPkFromDto(dto)) == null){
            dao.insert(convertToEntity(dto));
        }
        else {
            throw new ObjectAlreadyExistsException();
        }

    }

    public void update(SessionDto dto) throws UpdateObjectNotExistException {
        if (dao.findById(createSessionPkFromDto(dto)) != null){
            dao.update(convertToEntity(dto));
        }
        else {
            throw new UpdateObjectNotExistException();
        }

    }

    public boolean delete(SessionPkDto key) {
        if (dao.findById(convertToSessionPK(key)) != null){
            dao.delete(convertToSessionPK(key));
        }

        return false;
    }

    private Session convertToEntity(SessionDto dto){
        Session session = new Session();

        session.setCost(dto.getCost());
        session.setSessionTime(dto.getSessionTime());

        Track track = new Track();
        track.setId(dto.getTrackId());
        session.setTrack(track);

        User user = new User();
        user.setEmail(dto.getUserEmail());
        session.setUser(user);

        return session;
    }

    public SessionDto convertToDto(Session entity){
        if (entity != null) {
            SessionDto dto = new SessionDto();
            dto.setCost(entity.getCost());
            dto.setSessionTime(entity.getSessionTime());
            dto.setTrackId(entity.getTrack().getId());
            dto.setUserEmail(entity.getUser().getEmail());

            return dto;
        }

        return null;
    }

    public SessionPK convertToSessionPK(SessionPkDto dto){
        SessionPK pk = new SessionPK();
        pk.setSessionTime(dto.getSessionTime());
        pk.setTrack(trackService.convertToEntity(dto.getTrack()));

        return pk;
    }

    public SessionPK createSessionPkFromDto(SessionDto dto){
        SessionPK pk = new SessionPK();
        pk.setSessionTime(dto.getSessionTime());
        Track track = new Track();
        track.setId(dto.getTrackId());
        pk.setTrack(track);

        return pk;
    }
}
