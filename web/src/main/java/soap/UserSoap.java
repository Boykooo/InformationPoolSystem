package soap;

import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import dto.UserDto;
import services.UserService;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.POST;
import java.util.List;

@WebService(serviceName = "UserSoap")
public class UserSoap {

    @EJB
    private UserService service;

    @WebMethod
    public List<UserDto> getAllUsers() {
        return service.findAll();
    }

    @WebMethod
    public UserDto getSpecificUser(String email) {
        return (email != null) ? service.findById(email) : null;
    }

    @WebMethod
    @POST
    public void addUser(UserDto dto) throws ObjectAlreadyExistsException {
        if (dto != null) {
            service.insert(dto);
        }
    }

    @WebMethod
    public void updateUser(UserDto dto) throws UpdateObjectNotExistException {
        if (dto != null) {
            service.update(dto);
        }
    }

    @WebMethod
    public void deleteUser(String key) {
        if (key != null) {
            service.delete(key);
        }
    }
}
