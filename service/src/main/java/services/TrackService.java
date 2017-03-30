package services;

import dao.TrackDao;
import dto.TrackDto;

import javax.ejb.EJB;
import java.util.List;

public class TrackService implements IService<TrackDto,Integer> {

    @EJB
    private TrackDao trackDao;

    public TrackDto findById(Integer key) {
        return null;
    }

    public List<TrackDto> findAll() {
        return null;
    }

    public void insert(TrackDto trackDto) {

    }

    public void update(TrackDto trackDto) {

    }

    public boolean delete(Integer key) {
        return false;
    }
}
