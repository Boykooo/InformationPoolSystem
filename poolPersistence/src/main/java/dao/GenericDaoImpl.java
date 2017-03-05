package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    protected EntityManager manager;
    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        manager = emf.createEntityManager();
    }

    @Override
    public T findById(PK o) {
        return manager.find(entityClass, o);
    }

    @Override
    public List<T> findAll() {
//        javax.persistence.criteria.CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass.getClass()));
//        return manager.createQuery(cq).getResultList();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        CriteriaQuery<T> all = cq.select(cq.from(entityClass));
        TypedQuery<T> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
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
