package dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    protected EntityManager manager;
    private Class<T> entityClass;

    public GenericDaoImpl(EntityManager manager, Class<T> entityClass) {
        this.manager = manager;
        this.entityClass = entityClass;
    }

    @Override
    public T findById(PK o) {
        return null;
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass.getClass()));
        return manager.createQuery(cq).getResultList();
    }

    @Override
    public void insert(T o) {
        manager.persist(o);
    }

    @Override
    public void update(T o) {
        manager.merge(o);
    }

    @Override
    public boolean delete(PK o) {
        manager.remove(o);
        return true;
    }
}
