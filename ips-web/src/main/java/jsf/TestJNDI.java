package jsf;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("testJNDI")
@ManagedBean
@RequestScoped
public class TestJNDI {

    private String email;


    @PostConstruct
    public void init(){

    }

    public String getFirstName(){
        return null;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
