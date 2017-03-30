package services;

import Exceptions.EmailException;
import Exceptions.PoolNameException;
import Exceptions.SessionAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import dto.IBaseDto;

import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;

@Local
public interface IService<Entity extends IBaseDto, PK> {

    Entity findById(PK key);
    List<Entity> findAll();
    void insert(Entity entity) throws EmailException, PoolNameException, SessionAlreadyExistsException;
    void update(Entity entity) throws ObjectNotFoundException, UpdateObjectNotExistException;
    boolean  delete(PK key);

}
