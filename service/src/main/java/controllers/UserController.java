package controllers;

import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import Validation.DataValidator;
import dto.UserDto;
import services.UserService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.BadRequestException;
import java.util.List;

@Stateless
@LocalBean
public class UserController {

    @EJB
    private UserService service;
    @EJB
    private DataValidator validator;

    public UserDto getById(String key){
        if (key != null) {
            return service.findById(key);
        }

        throw new BadRequestException();
    }

    public List<UserDto> getAllUsers() {
        return service.findAll();
    }

    public void addUser(UserDto dto) throws ObjectAlreadyExistsException, BadRequestException {
        if (validator.check(dto)) {
            if (service.findById(dto.getEmail()) == null) {
            } else {
                throw new ObjectAlreadyExistsException();
            }
        } else {
            throw new BadRequestException();
        }
    }

    public void updateUser(UserDto dto) throws UpdateObjectNotExistException, BadRequestException {
        if (validator.check(dto)) {
            if (service.findById(dto.getEmail()) != null) {
                service.update(dto);
            } else {
                throw new UpdateObjectNotExistException();
            }
        } else {
            throw new BadRequestException();
        }

    }

    public boolean deleteUser(String key) throws BadRequestException {
        if (key != null) {
            return service.delete(key);
        }

        throw new BadRequestException();
    }
}
