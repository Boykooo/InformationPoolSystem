package services;

import Entities.Pool;
import Entities.Session;
import Entities.Track;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.ReferenceNotFoundException;
import Exceptions.UpdateObjectNotExistException;
import dao.TrackDao;
import dto.PoolDto;
import dto.SessionDto;
import dto.TrackDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Stateless
@LocalBean
public class TrackService implements IService<TrackDto, Integer> {

    @EJB
    private TrackDao dao;
    @EJB
    private SessionService sessionService;
    @EJB
    private PoolService poolService;

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

    public void insert(TrackDto dto) throws ObjectAlreadyExistsException, ReferenceNotFoundException {
        PoolDto pool = poolService.findById(dto.getPoolName());
        if (pool != null) {
            TrackDto foundTrack = pool.getTrackList().
                    stream().
                    filter((TrackDto trackDto) -> Objects.equals(trackDto.getNumber(), dto.getNumber())).
                    findFirst().
                    orElse(null);
            if (foundTrack == null) {
                dao.insert(convertToEntity(dto));
            } else {
                throw new ObjectAlreadyExistsException();
            }
        } else {
            throw new ReferenceNotFoundException(dto.getPoolName());
        }
    }

    public void update(TrackDto dto) throws UpdateObjectNotExistException, ReferenceNotFoundException, ObjectAlreadyExistsException {
        PoolDto pool = poolService.findById(dto.getPoolName());
        if (pool != null) {
            if (dao.findById(dto.getId()) != null) {
                TrackDto foundTrack = pool.getTrackList().
                        stream().
                        filter((TrackDto trackDto) -> Objects.equals(trackDto.getNumber(), dto.getNumber())).
                        findFirst().
                        orElse(null);
                if (foundTrack == null) {
                    dao.update(convertToEntity(dto));
                } else {
                    throw new ObjectAlreadyExistsException();
                }
            } else {
                throw new UpdateObjectNotExistException();
            }
        }
        else {
            throw new ReferenceNotFoundException(dto.getPoolName());
        }
    }

    public boolean delete(Integer key) {
        if (dao.findById(key) != null) {
            dao.delete(key);
            return true;
        }

        return false;
    }

    public Track convertToEntity(TrackDto dto) {
        Track track = new Track();
        if (dto.getId() != null)
        {
            track.setId(dto.getId());
        }
        track.setNumber(dto.getNumber());

        Pool pool = new Pool();
        pool.setName(dto.getPoolName());
        track.setPool(pool);

        //track.setSessionsList();

        return track;
    }

    public TrackDto convertToDto(Track entity) {
        if (entity != null) {
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

        return null;
    }
}
