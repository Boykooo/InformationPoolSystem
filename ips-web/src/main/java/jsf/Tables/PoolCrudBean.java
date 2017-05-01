package jsf.Tables;

import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import controllers.PoolController;
import dto.PoolDto;
import org.primefaces.context.RequestContext;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("poolCrudBean")
@ManagedBean
@RequestScoped
public class PoolCrudBean {

    @EJB
    private PoolController controller;
    private PoolDto dto;

    @PostConstruct
    private void init(){
        dto = new PoolDto();
    }

    public void add(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.insert(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Pool added successfully"));
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Pool updated successfully"));
        } catch (UpdateObjectNotExistException | InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('updateDialog').hide()");
    }

    public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.delete(dto.getName());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "Pool deleted successfully"));
        } catch (InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Required field name cannot be null"));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('deleteDialog').hide()");
    }

    public PoolDto getDto() {
        return dto;
    }
    public void setDto(PoolDto dto) {
        this.dto = dto;
    }

}
