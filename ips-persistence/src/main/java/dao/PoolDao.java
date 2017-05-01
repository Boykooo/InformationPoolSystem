package dao;

import Entities.Pool;

import javax.ejb.Stateless;

@Stateless
public class PoolDao extends GenericDaoImpl<Pool, String>{
    public PoolDao() {
        super(Pool.class);
    }
}
