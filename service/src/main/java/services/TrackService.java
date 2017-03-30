package services;

import Entities.Pool;
import Entities.Session;
import Entities.Track;
import Exceptions.UpdateObjectNotExistException;
import dao.TrackDao;
import dto.SessionDto;
import dto.TrackDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TrackService implements IService<TrackDto,Integer> {

    @EJB
    private TrackDao dao;
    @EJB
    private SessionService sessionService;

    public TrackDto findById(Integer key) {
        return convertToDto(dao.findById(key));
    }

    public List<TrackDto> findAll() {
        List<TrackDto> trackDtoList = new ArrayList<>();
        dao.findAll().forEach(
                (Track track) -> trackDtoList.add(convertToDto(track))
        );

        return trackDtoList;
    }

    public void insert(TrackDto dto) {
        dao.insert(convertToEntity(dto));
    }

    public void update(TrackDto dto) throws UpdateObjectNotExistException {
        if (dao.findById(dto.getId()) != null){
            dao.update(convertToEntity(dto));
        }
        else {
            throw new UpdateObjectNotExistException();
        }
    }

    public boolean delete(Integer key) {
        if (dao.findById(key) != null){
            dao.delete(key);
            return true;
        }

        return false;
    }

    public Track convertToEntity(TrackDto dto){
        Track track = new Track();
        track.setId(dto.getId());
        track.setNumber(dto.getNumber());

        Pool pool = new Pool();
        pool.setName(dto.getPoolName());
        track.setPool(pool);

        //track.setSessionsList();

        return track;
    }

    public TrackDto convertToDto(Track entity){
        TrackDto dto = new TrackDto();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setPoolName(entity.getPool().getName());

        List<SessionDto> sessionDtoList = new ArrayList<>();
        entity.getSessionsList().forEach(
                (Session session) -> sessionDtoList.add(sessionService.convertToDto(session))
        );
        dto.setSessionsList(sessionDtoList);

        return dto;
    }
}
