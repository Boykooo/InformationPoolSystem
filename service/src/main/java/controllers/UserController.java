package controllers;

import Exceptions.InvalidRequestException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import Validation.DataValidator;
import dto.UserDto;
import services.UserService;
import util.DataEncoder;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class UserController {

    @EJB
    private UserService service;
    @EJB
    private DataValidator validator;

    public UserDto findById(String key) throws InvalidRequestException {
        if (key != null) {
            return service.findById(key);
        }

        throw new InvalidRequestException();
    }

    public List<UserDto> findAll() {
        return service.findAll();
    }

    public void insert(UserDto dto) throws ObjectAlreadyExistsException, InvalidRequestException {
        if (!validator.check(dto)) {
            throw new InvalidRequestException();
        }

        dto.setPassword(DataEncoder.encode(dto.getPassword()));

        if (service.findById(dto.getEmail()) == null) {
            service.insert(dto);
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void fullUpdate(UserDto dto) throws UpdateObjectNotExistException, InvalidRequestException {
        if (!validator.check(dto)) {
            throw new InvalidRequestException();
        }

        dto.setPassword(DataEncoder.encode(dto.getPassword()));

        if (service.findById(dto.getEmail()) != null) {
            service.update(dto);
        } else {
            throw new UpdateObjectNotExistException();
        }
    }

    public boolean delete(String key) throws InvalidRequestException {
        if (key != null) {
            return service.delete(key);
        }

        throw new InvalidRequestException();
    }
}
