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
public abstract class GenericDaoImpl<Entity, PK> implements GenericDao<Entity, PK> {

    //@PersistenceContext
    protected EntityManager manager;
    private Class<Entity> entityClass;

    public GenericDaoImpl(Class<Entity> entityClass) {
        this.entityClass = entityClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        manager = emf.createEntityManager();
    }

    @Override
    public Entity findById(PK o) {
        return manager.find(entityClass, o);
    }

    @Override
    public List<Entity> findAll() {

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Entity> cq = cb.createQuery(entityClass);

        CriteriaQuery<Entity> all = cq.select(cq.from(entityClass));
        TypedQuery<Entity> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
    }

    @Override
    public void insert(Entity entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Entity entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public boolean delete(PK key) {
        Entity entity = findById(key);
        if (entity != null) {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
            return true;
        }

        return false;
    }
}
