package dao;

import Entities.User;

import javax.persistence.EntityManager;

public class UserDao extends GenericDaoImpl<User, Integer> {

    public UserDao(EntityManager manager) {
        super(manager, User.class);
    }
}
