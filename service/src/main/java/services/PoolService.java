package services;

import Entities.Pool;
import dao.PoolDao;
import dto.PoolDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PoolService implements IService<PoolDto,String> {

    @EJB
    private PoolDao dao;

    public PoolDto findById(String key) {
        return null;
    }

    public List<PoolDto> findAll() {
        return null;
    }

    public void insert(PoolDto poolDto) {

    }

    public void update(PoolDto poolDto) {

    }

    public boolean delete(String key) {
        return false;
    }

    private Pool convertToEntity(PoolDto dto){
        Pool pool = new Pool();
        pool.setDepth(dto.getDepth());
        pool.setIsWorking(dto.isWorking());
        pool.setLength(dto.getLength());
        pool.setName(dto.getName());
        pool.setType(dto.getType());

        pool.setTrackList(dto.getTrackList());
    }

    private PoolDto convertToDto(Pool dto){

    }
}
