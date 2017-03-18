package services.Abstract;

import Entities.IBaseEntity;
import dao.GenericDao;

import java.util.List;

public abstract class AbstractService<Entity extends IBaseEntity, PK> {

    protected GenericDao<Entity, PK> dao;

    public abstract Entity findById(PK o);

    public abstract List<Entity> findAll();

    public abstract void insert(Entity o);

    public abstract void update(Entity o);

    public abstract boolean  delete(PK o);

//    protected abstract Dto convertToDto(Entity entity);
//    protected abstract Entity convertToEntity(Dto dto);
}
