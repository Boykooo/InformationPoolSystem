package dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GenericDao<Entity, PK> {

    Entity findById(PK key);

    List<Entity> findAll();

    void insert(Entity entity);

    void update(Entity entity);

    boolean  delete(PK key);
}
