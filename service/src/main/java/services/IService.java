package services;

import Exceptions.EmailException;
import dto.IBaseDto;

import java.util.List;

public interface IService<Entity extends IBaseDto, PK> {

    Entity findById(PK key);
    List<Entity> findAll();
    void insert(Entity entity) throws EmailException;
    void update(Entity entity);
    boolean  delete(PK key);

}
