package jsf.Tables;


import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import controllers.UserController;
import dto.UserDto;
import org.primefaces.context.RequestContext;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("userCrudBean")
@ManagedBean
@RequestScoped
public class UserCrudBean {

    @EJB
    private UserController controller;
    private UserDto dto;

    @PostConstruct
    private void init(){
        dto = new UserDto();
    }

    public void add(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.insert(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "User added successfully"));
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "User updated successfully"));
        } catch (UpdateObjectNotExistException | InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('updateDialog').hide()");
    }

    public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.delete(dto.getEmail());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "User deleted successfully"));
        } catch (InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Required field email cannot be null"));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('deleteDialog').hide()");
    }

    public UserDto getDto() {
        return dto;
    }
    public void setDto(UserDto dto) {
        this.dto = dto;
    }
}
