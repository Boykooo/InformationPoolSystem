package services;

import Entities.Session;
import Entities.SessionPK;
import Entities.Track;
import Entities.User;
import dao.SessionDao;
import dto.SessionDto;
import dto.SessionPkDto;
import dto.TrackDto;

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

    public SessionDto findById(SessionDto dto) {
        return convertToDto(dao.findById(createSessionPkFromDto(dto)));
    }

    public List<SessionDto> findAll() {
        List<SessionDto> sessionsDto = new ArrayList<SessionDto>();

        dao.findAll().forEach(
                (Session session) -> sessionsDto.add(convertToDto(session))
        );

        return sessionsDto;
    }

    public void insert(SessionDto dto){
        dao.insert(convertToEntity(dto));
    }

    public void update(SessionDto dto)  {
        dao.update(convertToEntity(dto));
    }

    public boolean delete(SessionPkDto key) {
        return dao.delete(convertToSessionPK(key));
    }

    private Session convertToEntity(SessionDto dto){
        Session session = new Session();

        session.setCost(dto.getCost());
        session.setSessionTime(dto.getSessionTime());

        Track track = new Track();
        track.setId(dto.getTrack().getId());
        session.setTrack(track);

        if (dto.getUserEmail() != null) {
            User user = new User();
            user.setEmail(dto.getUserEmail());
            session.setUser(user);
        }

        return session;
    }

    public SessionDto convertToDto(Session entity){
        if (entity != null) {
            SessionDto dto = new SessionDto();
            dto.setCost(entity.getCost());
            dto.setSessionTime(entity.getSessionTime());

            //TODO: Придумать, как сделать лучше
            Track track = entity.getTrack();
            TrackDto trackDto = new TrackDto(track.getId(), track.getNumber(), track.getPool().getName());

            dto.setTrack(trackDto);
            if (entity.getUser() != null) {
                dto.setUserEmail(entity.getUser().getEmail());
            }

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
        track.setId(dto.getTrack().getId());
        pk.setTrack(track);

        return pk;
    }
}
