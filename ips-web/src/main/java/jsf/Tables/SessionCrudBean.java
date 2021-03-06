package jsf.Tables;

import controllers.SessionController;
import dto.SessionDto;
import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import org.primefaces.context.RequestContext;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.Timestamp;
import java.util.Date;

@Named("sessionCrudBean")
@ManagedBean
@RequestScoped
public class SessionCrudBean {

    @EJB
    private SessionController controller;
    private SessionDto dto;
    private Date date;

    @PostConstruct
    private void init(){
        dto = new SessionDto();
    }

    public void add(){

        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            controller.insert(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Session added successfully"));
        } catch (ObjectAlreadyExistsException | InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('addDialog').hide()");
    }

    public void fullUpdate(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.fullUpdate(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Session updated successfully"));
        } catch (UpdateObjectNotExistException | InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('updateDialog').hide()");
    }

    public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.delete(dto.getSessionTime(), dto.getTrack());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Session deleted successfully"));
        } catch (InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Required fields date and track id cannot be null"));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('deleteDialog').hide()");
    }

    //region GetSet

    public SessionDto getDto() {
        return dto;
    }
    public void setDto(SessionDto dto) {
        this.dto = dto;
    }

    public Date getDate() {
        return null;
    }

    public void setDate(Date date) {
        Timestamp time = new Timestamp(date.getTime());
        this.dto.setSessionTime(time);
    }

    //endregion
}
