package dao;

import Entities.User;

public class UserDao extends GenericDaoImpl<User, Integer> {

    public UserDao() {
        super(User.class);
    }
}
