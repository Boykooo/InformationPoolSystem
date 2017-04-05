package controllers;

import Exceptions.InvalidRequestException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import Validation.DataValidator;
import dto.SessionDto;
import dto.SessionPkDto;
import services.SessionService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class SessionController {

    @EJB
    private SessionService service;
    @EJB
    private DataValidator validator;
    @EJB
    private UserController userController;

    public SessionDto findById(SessionPkDto key) throws InvalidRequestException {
        if (!validator.check(key)){
            throw new InvalidRequestException();
        }

        return service.findById(key);
    }

    public List<SessionDto> findAll(){
        return service.findAll();
    }

    public void insert(SessionDto dto) throws ObjectAlreadyExistsException, InvalidRequestException {
        if (!validator.check(dto)){
            throw new InvalidRequestException();
        }

        if (service.findById(dto) == null){
            service.insert(dto);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void update(SessionDto dto) throws UpdateObjectNotExistException, InvalidRequestException {
        if (!validator.check(dto)){
            throw new InvalidRequestException();
        }

        if (service.findById(dto) != null){
            if (userController.findById(dto.getUserEmail()) != null){
                    service.update(dto);
            }
            else {
                throw new InvalidRequestException();
            }
        }
        else {
            throw new UpdateObjectNotExistException();
        }
    }

    public boolean deleteSession(SessionPkDto key) throws InvalidRequestException {
        if (!validator.check(key)){
            throw new InvalidRequestException();
        }

        return service.delete(key);
    }
}
