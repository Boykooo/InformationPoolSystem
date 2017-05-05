package jsf;

import controllers.UserController;
import dto.UserDto;
import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import org.primefaces.context.RequestContext;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("userBean")
@ManagedBean
@RequestScoped
public class UserBean {

    @EJB
    private UserController controller;
    private UserDto user;

    @PostConstruct
    private void init(){
        user = new UserDto();
    }


    public void signUp(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.insert(user);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Успех", "Регистрация прошла успешно"));
        } catch (ObjectAlreadyExistsException | InvalidRequestException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", e.getMessage()));
        }

        RequestContext.getCurrentInstance().execute("PF('registrationDialog').hide()");
    }

    public void signIn(){

    }

    public UserDto getUser() {
        return user;
    }
    public void setUser(UserDto user) {
        this.user = user;
    }
}
