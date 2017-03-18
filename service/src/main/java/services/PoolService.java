package services;

import Entities.Pool;
import dao.PoolDao;
import services.Abstract.AbstractService;

import java.util.List;

public class PoolService extends AbstractService<Pool, Integer> {

    public PoolService() {
        super();
        dao = new PoolDao();
    }

    @Override
    public Pool findById(Integer o) {
        return null;
    }

    @Override
    public List<Pool> findAll() {
        return null;
    }

    @Override
    public void insert(Pool o) {

    }

    @Override
    public void update(Pool o) {

    }

    @Override
    public boolean delete(Integer o) {
        return false;
    }
}
