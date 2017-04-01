package jsf;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("loginBean")
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{
    private String username;
    private String password;

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

    public String login(){
        if (username.equals("admin") && username.equals("admin")){
            return "success";
        }

        return "failure";
    }
}
