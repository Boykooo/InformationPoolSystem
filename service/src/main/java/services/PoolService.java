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
        return dao.findById(o);
    }

    @Override
    public List<Pool> findAll() {
        return dao.findAll();
    }

    @Override
    public void insert(Pool o) {
        dao.insert(o);
    }

    @Override
    public void update(Pool o) {
        dao.update(o);
    }

    @Override
    public boolean delete(Integer o) {
        Pool pool = this.findById(o);
        if (pool != null){
            dao.delete(o);
            return true;
        }

        return false;
    }
}
