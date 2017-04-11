package dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Local
@Transactional
public abstract class GenericDaoImpl<Entity, PK> implements GenericDao<Entity, PK> {

    @PersistenceContext
    protected EntityManager manager;
    private Class<Entity> entityClass;

    public GenericDaoImpl(Class<Entity> entityClass) {
        this.entityClass = entityClass;
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
        manager.persist(entity);
    }

    @Override
    public void update(Entity entity) {
        manager.merge(entity);
    }

    @Override
    public boolean delete(PK key) {
        Entity entity = findById(key);
        if (entity != null) {
            manager.remove(entity);
            return true;
        }

        return false;
    }
}
