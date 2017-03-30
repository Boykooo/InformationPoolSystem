package services;

import dao.UserDao;
import dto.UserDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService implements IService<UserDto, String> {

    @EJB
    protected UserDao dao;

    public UserService() {
        super();
    }

    public UserDto findById(String o) {
        return null;
        //return dao.findById(o);
        //return convertToDto(dao.findById(o));
    }

    public List<UserDto> findAll() {

        return null;

        //return dao.findAll();
//        List<User> users = dao.findAll();
//        List<UserDto> userDtoList = new ArrayList<UserDto>();
//
//        for (int i = 0; i < users.size(); i++) {
//            userDtoList.add(convertToDto(users.get(i)));
//        }
//
//        return userDtoList;
    }

    public void insert(UserDto o) {
        List<UserDto> users = this.findAll();

        boolean found = false;
        for (int i = 0; i < users.size() && !found; i++) {
            found = users.get(i).getEmail().equals(o.getEmail());
        }

        if (!found) {
            //dao.insert(o);
        } else {
            //TODO: ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ
        }
    }

    public void update(UserDto o) {
        //dao.update(o);
    }

    public boolean delete(String o) {
//        User user = this.findById(o);
//        if (user != null){
//            dao.delete(o);
//            return true;
//        }

        return false;
    }

//    protected UserDto convertToDto(User entity) {
//        UserDto userDto = new UserDto();
//        userDto.setFirstName(entity.getFirstName());
//        userDto.setLastName(entity.getLastName());
//        userDto.setPhoneNumber(entity.getPhoneNumber());
//        userDto.setEmail(entity.getEmail());
//
//        return userDto;
//    }
//
//    protected User convertToEntity(UserDto dto) {
//        User user = new User();
}
