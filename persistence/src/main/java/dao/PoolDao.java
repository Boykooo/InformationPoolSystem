package dao;

import Entities.Pool;

import javax.persistence.EntityManager;

public class PoolDao extends GenericDaoImpl<Pool, Integer>{

    public PoolDao(EntityManager manager) {
        super(manager, Pool.class);
    }
}
