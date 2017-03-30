package services;

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
}
