package jsf.Tables;


import Exceptions.InvalidRequestException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import controllers.UserController;
import dto.UserDto;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("userBean")
@ManagedBean
@RequestScoped
public class UserBean {

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
        requestContext.execute("PF('addUserDialog').hide()");
    }

    public void update(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            controller.update(dto);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully", "User updated successfully"));
        } catch (UpdateObjectNotExistException | InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('udapteUserDialog').hide()");
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
        requestContext.execute("PF('deleteUserDialog').hide()");
    }

    public void onRowSelect(SelectEvent event){
        dto = (UserDto) event.getObject();
    }

    public UserDto getDto() {
        return dto;
    }
    public void setDto(UserDto dto) {
        this.dto = dto;
    }
}
