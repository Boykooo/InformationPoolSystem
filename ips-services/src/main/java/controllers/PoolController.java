package controllers;

import dto.SessionDto;
import dto.TrackDto;
import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import Validation.DataValidator;
import dto.PoolDto;
import services.PoolService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


@Stateless
@LocalBean
public class PoolController {

    @EJB
    private PoolService service;
    @EJB
    private DataValidator validator;

    public PoolDto findById(String key) throws InvalidRequestException {
        if (key != null) {
            return service.findById(key);
        }

        throw new InvalidRequestException();
    }

    public List<PoolDto> findAll() {
        return service.findAll();
    }

    public void insert(PoolDto dto) throws ObjectAlreadyExistsException, InvalidRequestException {
        if (!validator.check(dto)) {
            throw new InvalidRequestException();
        }

        if (service.findById(dto.getName()) == null) {
            service.insert(dto);
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void fullUpdate(PoolDto dto) throws UpdateObjectNotExistException, InvalidRequestException {
        if (!validator.check(dto)) {
            throw new InvalidRequestException();
        }

        if (service.findById(dto.getName()) != null) {
            service.update(dto);
        } else {
            throw new UpdateObjectNotExistException();
        }
    }

    public boolean delete(String key) throws InvalidRequestException {
        if (key != null) {
            return service.delete(key);
        }

        throw new InvalidRequestException();
    }

    public List<SessionDto> getFreeSession(String poolName) throws InvalidRequestException {
        List<TrackDto> tracks = findById(poolName).getTrackList();
        List<SessionDto> freeSession = new ArrayList<>();

        for (TrackDto track : tracks) {
            for (SessionDto session : track.getSessionsList()) {
                if (session.getUserEmail() == null){
                    freeSession.add(session);
                }
            }
        }

        return freeSession;
    }

    public List<PoolDto> getWorkingPools(){
        List<PoolDto> all = findAll();
        ArrayList<PoolDto> workingPools = new ArrayList<>();

        for (PoolDto dto : all){
            if (dto.getIsWorking()){
                workingPools.add(dto);
            }
        }

        return workingPools;
    }
}






















