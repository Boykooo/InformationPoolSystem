package services.Abstract;

import Entities.IBaseEntity;
import dao.GenericDao;

import java.util.List;

public abstract class AbstractService<T extends IBaseEntity, PK> {

    protected GenericDao<T, PK> dao;

    protected abstract T findById(PK o);

    protected abstract List<T> findAll();

    protected abstract void insert(T o);

    protected abstract void update(T o);

    protected abstract boolean  delete(PK o);
}
