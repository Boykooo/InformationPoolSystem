package services;

import Entities.Pool;
import dao.PoolDao;
import services.Abstract.AbstractService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PoolService extends AbstractService<Pool, Integer> {

    @EJB
    private PoolDao dao;

    public PoolService() {
        super();
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
