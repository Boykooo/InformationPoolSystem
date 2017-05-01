package dao;

import Entities.User;

import javax.ejb.Stateless;

@Stateless
public class UserDao extends GenericDaoImpl<User, String> {
    public UserDao() {
        super(User.class);
    }
}
