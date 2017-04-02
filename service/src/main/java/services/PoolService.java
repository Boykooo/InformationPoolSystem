package services;

import Entities.Pool;
import Entities.Track;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import dao.PoolDao;
import dto.PoolDto;
import dto.TrackDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class PoolService implements IService<PoolDto,String> {

    @EJB
    private PoolDao dao;
    @EJB
    private TrackService trackService;

    public PoolDto findById(String key) {
        return convertToDto(dao.findById(key));
    }

    public List<PoolDto> findAll() {
        List<PoolDto> poolDtoList = new ArrayList<>();

        dao.findAll().forEach(
                (Pool pool) -> poolDtoList.add(convertToDto(pool))
        );

        return poolDtoList;
    }

    public void insert(PoolDto poolDto) throws ObjectAlreadyExistsException {
        if (dao.findById(poolDto.getName()) == null){
            dao.insert(convertToEntity(poolDto));
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void update(PoolDto poolDto) throws UpdateObjectNotExistException {
        if (dao.findById(poolDto.getName()) != null){
            dao.update(convertToEntity(poolDto));
        }
        else {
            throw new UpdateObjectNotExistException();
        }
    }

    public boolean delete(String key) {
        if (dao.findById(key) != null){
            dao.delete(key);
            return true;
        }

        return false;
    }

    private Pool convertToEntity(PoolDto dto){
        Pool pool = new Pool();
        pool.setDepth(dto.getDepth());
        pool.setIsWorking(dto.getIsWorking());
        pool.setLength(dto.getLength());
        pool.setName(dto.getName());
        pool.setType(dto.getType());
        pool.setWidth(dto.getWidth());
        //pool.setTrackList(dto.getTrackList());

        return pool;
    }

    private PoolDto convertToDto(Pool entity){
        PoolDto dto = new PoolDto();
        dto.setWidth(entity.getWidth());
        dto.setDepth(entity.getDepth());
        dto.setLength(entity.getLength());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setIsWorking(entity.getIsWorking());

        List<TrackDto> trackDtoList = new ArrayList<>();
        entity.getTrackList().forEach(
                (Track track) -> trackDtoList.add(trackService.convertToDto(track))
        );
        dto.setTrackList(trackDtoList);

        return dto;
    }
}
