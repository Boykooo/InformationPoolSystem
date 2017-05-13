package jsf.Tables;

import controllers.PoolController;
import dto.PoolDto;
import dto.TrackDto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("poolTableBean")
@ManagedBean
@RequestScoped
public class PoolTableBean {

    @EJB
    private PoolController controller;
    private List<PoolDto> pools;
    private PoolDto selectedPool;

    @PostConstruct
    private void init(){
        pools = controller.findAll();
        selectedPool = new PoolDto();

        // ВРЕМЕННО!
        List<String> images = new ArrayList<>();
        images.add("/resources/images/poolImages/baby.jpg");
        images.add("/resources/images/poolImages/base.jpg");
        images.add("/resources/images/poolImages/mini.jpg");

        for (int i = 0; i < images.size(); i++) {
            if (pools.size() > i)
            {
                pools.get(i).setPicture(images.get(i));
            }
        }
    }

    public List<PoolDto> getPools() {
        return pools;
    }
    public List<PoolDto> getWorkingPools(){
        List<PoolDto> working = new ArrayList<>();

        for (PoolDto pool : pools) {
            if (pool.getIsWorking()) {
                working.add(pool);
            }
        }

        return working;
    }

    public List<TrackDto> getTracks(PoolDto dto){
        return dto.getTrackList();
    }

    public PoolDto getSelectedPool() {
        return selectedPool;
    }
    public void setSelectedPool(PoolDto selectPool) {
        this.selectedPool = selectPool;
    }

}
