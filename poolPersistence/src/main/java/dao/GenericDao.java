package dao;

import java.util.List;

public interface GenericDao<T, PK> {

    T findById(PK o);

    List<T> findAll();

    void insert(T o);

    void update(T o);

    boolean  delete(PK o);
}
