package dao;

import Entities.Pool;

import javax.ejb.Stateless;

@Stateless
public class PoolDao extends GenericDaoImpl<Pool, Integer>{
    public PoolDao() {
        super(Pool.class);
    }
}
