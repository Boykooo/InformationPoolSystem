package services;

import Entities.Session;
import Entities.User;
import dao.UserDao;
import dto.SessionDto;
import dto.UserDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class UserService implements IService<UserDto, String> {

    @EJB
    private UserDao dao;
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

    public void insert(UserDto dto) {
        dao.insert(convertToEntity(dto));
    }

    public void update(UserDto dto) {
        dao.update(convertToEntity(dto));
    }

    public boolean delete(String key) {
        return dao.delete(key);
    }

    public UserDto convertToDto(User entity) {
        if (entity != null) {
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

        return null;
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
