package jsf;

import controllers.UserController;
import dto.UserDto;
import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named("userBean")
@ManagedBean(name = "userBeanFaces")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserController controller;
    private UserDto user;
    private String redirectURL;
    private String homeURL;
    private boolean isLogin;
    private String personalAreaURL;
    private String orderTrackURL;

    @PostConstruct
    private void init() {
        user = new UserDto();
        redirectURL = "home.xhtml";
        homeURL = "/public/website/home.xhtml";
        personalAreaURL = "user/personalArea.xhtml";
        orderTrackURL = "user/orderTrack.xhtml";
        isLogin = false;
    }

    public void logout() throws IOException {
        isLogin = false;
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath() + homeURL);
    }

    public void signUp() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.insert(user);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Успех", "Регистрация прошла успешно"));
        } catch (ObjectAlreadyExistsException | InvalidRequestException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", e.getMessage()));
        }

        RequestContext.getCurrentInstance().execute("PF('registrationDialog').hide()");
    }

    public void signIn() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(user.getEmail(), user.getPassword());
            externalContext.redirect(externalContext.getRequestContextPath() + homeURL);
            isLogin = true;
            user = controller.findById(user.getEmail());
        } catch (ServletException | InvalidRequestException | IOException e) {
            // Handle unknown username/password in request.login().
            externalContext.invalidateSession();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            isLogin = false;
        }
    }

    public void toPrivateArea() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        externalContext.redirect(personalAreaURL);
    }

    public void toOrderTrack() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        if (isLogin){
            externalContext.redirect(orderTrackURL);
        }
        else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Войдите в систему"));
        }
    }

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    //region GetSet

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public boolean isLogin() {
        return isLogin;
    }

    //endregion
}
