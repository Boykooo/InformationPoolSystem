package dao;

import Entities.User;

import javax.transaction.Transactional;

@Transactional
    public class UserDao extends GenericDaoImpl<User, Integer> {

    public UserDao() {
        super(User.class);
    }
}
