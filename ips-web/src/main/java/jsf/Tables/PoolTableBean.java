package jsf.Tables;

import controllers.PoolController;
import dto.PoolDto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("poolTableBean")
@ManagedBean
@RequestScoped
public class PoolTableBean {

    @EJB
    private PoolController controller;
    private List<PoolDto> pools;

    @PostConstruct
    private void init(){
        pools = controller.findAll();
    }

    public List<PoolDto> getPools() {
        return pools;
    }

}
