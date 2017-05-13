package jsf;

import controllers.SessionController;
import controllers.TrackController;
import dto.SessionDto;
import dto.SessionPkDto;
import dto.TrackDto;
import exceptions.InvalidRequestException;
import exceptions.UpdateObjectNotExistException;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.Timestamp;
import java.util.Date;

@Named("orderBean")
@ManagedBean
@RequestScoped
public class OrderBean {

    @EJB
    private TrackController trackController;
    @EJB
    private SessionController sessionController;

//    @ManagedProperty(value = "userBeanFaces")
//    private UserBean userBean;

    private String poolName;
    private Integer trackNumber;
    private Date date;

    @PostConstruct
    private void init() {
    }

    public void order() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            TrackDto trackDto = trackController.findById(trackNumber, poolName);
            if (trackDto != null) {
                Timestamp timestamp = new Timestamp(date.getTime());
                SessionPkDto pkDto = new SessionPkDto(timestamp, trackDto);
                SessionDto sessionDto = sessionController.findById(pkDto);
                if (sessionDto != null) {
                    if (sessionDto.getUserEmail() == null) {
                        UserBean userBean = context.getApplication().evaluateExpressionGet(context,"#{userBean}", UserBean.class);
                        sessionDto.setUserEmail(userBean.getUser().getEmail());
                        sessionController.fullUpdate(sessionDto);
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Успех", "Бронирование прошло успешно"));
                    } else {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Данный сеанс уже занят"));
                    }
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Такого сеанса не существует"));
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Такой дорожки не существует"));
            }
        } catch (InvalidRequestException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", e.getMessage()));
        } catch (UpdateObjectNotExistException e) {
            e.printStackTrace();
        }
    }

    //region GetSet

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //endregion
}
