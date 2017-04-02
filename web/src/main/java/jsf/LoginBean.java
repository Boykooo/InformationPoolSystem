package jsf;

import Entities.Admin;
import dao.AdminDao;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named("loginBean")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

    @EJB
    private AdminDao dao;

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

    public String login() {
        Admin admin = dao.findById(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return "SUCCESS";
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid"));
        return null;
    }
}











