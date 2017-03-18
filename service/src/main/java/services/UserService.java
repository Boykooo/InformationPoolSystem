package services;

import Entities.User;
import dao.GenericDao;
import dao.UserDao;
import dto.UserDto;
import services.Abstract.AbstractService;

import java.util.ArrayList;
import java.util.List;

public class UserService extends AbstractService<UserDto, Integer> {

    private GenericDao<User, Integer> dao;

    public UserService() {
        dao = new UserDao();
    }

    @Override
    public UserDto findById(Integer o) {
        User user = dao.findById(o);

    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = dao.findAll();
        List<UserDto> userDtoList = new ArrayList<UserDto>();

        for (int i = 0; i < users.size(); i++) {
            UserDto userDto = new UserDto();

            userDto.setFirstName(users.get(i).getFirstName());
            userDto.setLastName(users.get(i).getLastName());
            userDto.setPhoneNumber(users.get(i).getPhoneNumber());
            userDto.setEmail(users.get(i).getEmail());
            userDto.setSessions(users.get(i).getSessionsByUserId());
        }

        return userDtoList;
    }

    @Override
    public void insert(UserDto o) {

    }

    @Override
    public void update(UserDto o) {

    }

    @Override
    public boolean delete(Integer o) {
        return false;
    }
}