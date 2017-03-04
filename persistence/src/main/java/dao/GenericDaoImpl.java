package dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    protected EntityManager manager;

    public GenericDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public T findById(PK id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void insert(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public boolean delete(PK key) {
        return false;
    }
}
