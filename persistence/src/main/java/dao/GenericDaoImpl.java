package dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    protected EntityManager manager;
    private Class<?> entityClass;

    public GenericDaoImpl(EntityManager manager, Class<T> type) {
        this.manager = manager;
        this.entityClass = type;
    }

    @Override
    public T findById(PK id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return manager.createQuery(cq).getResultList();
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
