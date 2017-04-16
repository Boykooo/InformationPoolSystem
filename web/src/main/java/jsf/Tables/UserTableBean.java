package jsf.Tables;

import controllers.UserController;
import dto.UserDto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("userTableBean")
@ManagedBean
@RequestScoped
public class UserTableBean {

    @EJB
    private UserController controller;
    private List<UserDto> users;

    @PostConstruct
    private void init() {
        users = controller.findAll();

    }

    public List<UserDto> getAllUsers() {
        return users;
    }
}
