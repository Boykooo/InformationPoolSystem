package services;

import Exceptions.ObjectAlreadyExistsException;
import Exceptions.ReferenceNotFoundException;
import Exceptions.UpdateObjectNotExistException;
import dto.IBaseDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IService<Entity extends IBaseDto, PK> {

    Entity findById(PK key);
    List<Entity> findAll();
    void insert(Entity entity) throws ObjectAlreadyExistsException, ReferenceNotFoundException;
    void update(Entity entity) throws UpdateObjectNotExistException, ReferenceNotFoundException, ObjectAlreadyExistsException;
    boolean delete(PK key);

}
