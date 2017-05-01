package jsf.Tables;

import controllers.SessionController;
import dto.SessionDto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("sessionTableBean")
@ManagedBean
@RequestScoped
public class SessionTableBean {

    @EJB
    private SessionController controller;
    private List<SessionDto> sessions;

    @PostConstruct
    private void init(){
        sessions = controller.findAll();
    }

    public List<SessionDto> getSessions() {
        return sessions;
    }
}
