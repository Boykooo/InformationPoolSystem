package dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Local
public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    //@PersistenceContext
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

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        CriteriaQuery<T> all = cq.select(cq.from(entityClass));
        TypedQuery<T> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
    }

    @Override
    public void insert(T o) {
        manager.getTransaction().begin();
        manager.persist(o);
        manager.getTransaction().commit();
    }

    @Override
    public void update(T o) {
        manager.getTransaction().begin();
        manager.merge(o);
        manager.getTransaction().commit();
    }

    @Override
    public boolean delete(PK o) {

        T entity = findById(o);

        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();

        return true;
    }
}
