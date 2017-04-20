package jsf;

import dao.AdminDao;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named("loginBean")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private String redirectURL;
    private boolean isLogin;


    @EJB
    private AdminDao dao;

    @PostConstruct
    protected void init() {
        redirectURL = "adminPanel.xhtml";
    }

    public boolean isLoggedOut() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        return !(request.isUserInRole("ADMIN") || (request.isUserInRole("USER")));
    }

    public void logout() throws IOException {
        isLogin = false;
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
    }

    public String login() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(username, password);
            if (request.isUserInRole("USER"))
            {
                externalContext.invalidateSession();
            }
            externalContext.redirect(redirectURL);
            isLogin = true;
        } catch (ServletException | IOException e) {
            // Handle unknown username/password in request.login().
            externalContext.invalidateSession();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unknown login", "User or password is incorrect."));
        }

        isLogin = false;

//        Admin admin = dao.findById(username);
//
//        if (admin != null && admin.getPassword().equals(password)) {
//            return "SUCCESS";
//        }
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid data"));
        return null;
    }

    //region GetSet

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogin() {
        return isLogin;
    }

    //endregion
}









