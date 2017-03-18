package services;

import Entities.User;
import dao.GenericDao;
import dao.UserDao;
import services.Abstract.AbstractService;

import java.util.List;

public class UserService extends AbstractService<User, Integer> {

    protected GenericDao<User, Integer> dao;

    public UserService() {
        super();
        dao = new UserDao();
    }

    @Override
    public User findById(Integer o) {
        return dao.findById(o);
        //return convertToDto(dao.findById(o));
    }

    @Override
    public List<User> findAll() {

        return dao.findAll();
//        List<User> users = dao.findAll();
//        List<UserDto> userDtoList = new ArrayList<UserDto>();
//
//        for (int i = 0; i < users.size(); i++) {
//            userDtoList.add(convertToDto(users.get(i)));
//        }
//
//        return userDtoList;
    }

    @Override
    public void insert(User o) {
        List<User> users = this.findAll();

        boolean found = false;
        for (int i = 0; i < users.size() && !found; i++) {
            found = users.get(i).getEmail().equals(o.getEmail());
        }

        if (!found){
            dao.insert(o);
        }
        else {
            //TODO: ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ
        }
    }

    @Override
    public void update(User o) {
        dao.update(o);
    }

    @Override
    public boolean delete(Integer o) {
        User user = this.findById(o);
        if (user != null){
            dao.delete(o);
            return true;
        }

        return false;
    }

//    @Override
//    protected UserDto convertToDto(User entity) {
//        UserDto userDto = new UserDto();
//        userDto.setFirstName(entity.getFirstName());
//        userDto.setLastName(entity.getLastName());
//        userDto.setPhoneNumber(entity.getPhoneNumber());
//        userDto.setEmail(entity.getEmail());
//        userDto.setSessions(entity.getSessionsByUserId());
//
//        return userDto;
//    }
//
//    @Override
//    protected User convertToEntity(UserDto dto) {
//        User user = new User();
//    }
}