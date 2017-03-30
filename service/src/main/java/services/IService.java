package services;

import Exceptions.EmailException;
import Exceptions.PoolNameException;
import dto.IBaseDto;

import javax.ejb.ObjectNotFoundException;
import java.util.List;

public interface IService<Entity extends IBaseDto, PK> {

    Entity findById(PK key);
    List<Entity> findAll();
    void insert(Entity entity) throws EmailException, PoolNameException;
    void update(Entity entity) throws ObjectNotFoundException;
    boolean  delete(PK key);

}
