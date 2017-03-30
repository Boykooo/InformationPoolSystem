package services;

import Entities.Session;
import Entities.User;
import Exceptions.EmailException;
import dao.UserDao;
import dto.SessionDto;
import dto.UserDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService implements IService<UserDto, String> {

    @EJB
    protected UserDao dao;
    @EJB
    private SessionService sessionService;

    public UserService() {
        super();
    }

    public UserDto findById(String key) {
        return convertToDto(dao.findById(key));
    }

    public List<UserDto> findAll() {

        List<UserDto> userDtoList = new ArrayList<>();
        dao.findAll().forEach(
                (User user) -> userDtoList.add(convertToDto(user))
        );

        return userDtoList;
    }

    public void insert(UserDto dto) throws EmailException {
        List<User> users = dao.findAll();

        User foundUser = users.stream()
                .filter(user -> user.getEmail().equals(dto.getEmail()))
                .findFirst()
                .get();


        if (foundUser == null) {
            dao.insert(convertToEntity(dto));
        } else {
            throw new EmailException();
        }
    }

    public void update(UserDto dto) {
        dao.update(convertToEntity(dto));
    }

    public boolean delete(String key) {
        User user = dao.findById(key);
        if (user != null){
            dao.delete(key);
            return true;
        }
        return false;
    }


    public UserDto convertToDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setPhoneNumber(entity.getPhoneNumber());
        userDto.setEmail(entity.getEmail());

        List<SessionDto> sessionDtoList = new ArrayList<>();
        entity.getSessionsList().forEach(
                (Session session) -> sessionDtoList.add(sessionService.convertToDto(session))
        );

        userDto.setSessionsList(sessionDtoList);

        return userDto;
    }

    public User convertToEntity(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());
        user.setLastName(dto.getLastName());
        //user.setSessionsList(.....);

        return user;
    }
}
