package jsf.Tables;

import controllers.TrackController;
import dto.TrackDto;
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

@Named("trackCrudBean")
@ManagedBean
@RequestScoped
public class TrackCrudBean {

    @EJB
    private TrackController controller;
    private TrackDto dto;

    @PostConstruct
    private void init(){
        dto = new TrackDto();
    }

    public void add(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.insert(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Track added successfully"));
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Track updated successfully"));
        } catch (UpdateObjectNotExistException | InvalidRequestException | ObjectAlreadyExistsException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('updateDialog').hide()");
    }

    public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.delete(dto.getId());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Track deleted successfully"));
        } catch (InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Required field id cannot be null"));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('deleteDialog').hide()");
    }

    //region GetSet

    public TrackDto getDto() {
        return dto;
    }
    public void setDto(TrackDto dto) {
        this.dto = dto;
    }

    //endregion
}
