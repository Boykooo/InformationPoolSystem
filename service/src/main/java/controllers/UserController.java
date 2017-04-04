package controllers;

import Exceptions.CannotBeNullException;
import Exceptions.ObjectAlreadyExistsException;
import dto.UserDto;
import services.UserService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class UserController {

    @EJB
    private UserService userService;

    public void addUser(UserDto dto) throws ObjectAlreadyExistsException, CannotBeNullException {
        if (dto.getEmail() != null){
            if (userService.findById(dto.getEmail()) == null)
            {

            }
            else {
                throw new ObjectAlreadyExistsException();
            }
        }
        else {
            throw new CannotBeNullException("email");
        }
    }
}
