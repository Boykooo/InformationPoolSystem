package jsf;

import controllers.PoolController;
import controllers.SessionController;
import controllers.TrackController;
import dto.SessionDto;
import dto.SessionPkDto;
import dto.TrackDto;
import exceptions.InvalidRequestException;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("orderBean")
@ManagedBean
@RequestScoped
public class OrderBean {

    @EJB
    private TrackController trackController;
    @EJB
    private SessionController sessionController;
    @EJB
    private PoolController poolController;

    private String poolName;
    private Integer trackNumber;
    private Date date;
    private List<SessionDto> freeSessions;

    @PostConstruct
    private void init() {
        freeSessions = new ArrayList<>();
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
                        UserBean userBean = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);
                        sessionDto.setUserEmail(userBean.getUser().getEmail());
                        sessionController.fullUpdate(sessionDto);
                        userBean.updateUser();

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

    public List<SessionDto> getFreeSessions() throws InvalidRequestException {
        if (poolName != null) {

            List<SessionDto> freeSession = poolController.getFreeSession(poolName);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date currDate = new Date();

            freeSessions.clear();
            for (SessionDto session : freeSession){
                if (dateFormat.format(session.getSessionTime()).equals(dateFormat.format(currDate)))
                {
                    freeSessions.add(session);
                }
            }

            return freeSessions;
        }

        return null;
    }

    public void openFreeSessionDialog()  {
        try {
            getFreeSessions();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('freeSessionDialog').show()");
    }

    public List<SessionDto> getFreeSessionsList() {
        return freeSessions;
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
