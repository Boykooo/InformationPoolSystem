package services;

import Entities.User;
import dao.UserDao;
import services.Abstract.AbstractService;

import java.util.List;

public class UserService extends AbstractService<User, Integer> {


    public UserService() {
        dao = new UserDao();
    }

    @Override
    public User findById(Integer o) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void insert(User o) {

    }

    @Override
    public void update(User o) {

    }

    @Override
    public boolean delete(Integer o) {
        return false;
    }
}