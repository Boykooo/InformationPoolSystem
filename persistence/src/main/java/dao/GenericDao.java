package dao;

import java.util.List;

public interface GenericDao<T, PK> {

    T findById(PK id);

    List<T> findAll();

    void insert(T entity);

    void update(T entity);

    boolean delete(PK key);
}
