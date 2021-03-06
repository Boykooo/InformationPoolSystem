package controllers;

import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import Validation.DataValidator;
import dto.PoolDto;
import dto.TrackDto;
import services.PoolService;
import services.TrackService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Objects;

@Stateless
@LocalBean
public class TrackController {

    @EJB
    private TrackService trackService;
    @EJB
    private DataValidator validator;
    @EJB
    private PoolService poolService;

    public TrackDto findById(Integer key) throws InvalidRequestException {
        if (key != null) {
            return trackService.findById(key);
        }

        throw new InvalidRequestException();
    }

    public TrackDto findById(Integer number, String poolName) throws InvalidRequestException {
        if (number != null && poolName != null) {

            List<TrackDto> traks = trackService.findAll();
            for (TrackDto trackDto : traks) {
                if (trackDto.getPoolName().equals(poolName) && trackDto.getNumber().equals(number)){
                    return trackDto;
                }
            }

        } else {
            throw new InvalidRequestException();
        }

        return null;
    }

    public List<TrackDto> findAll() {
        return trackService.findAll();
    }

    public void insert(TrackDto dto) throws InvalidRequestException, ObjectAlreadyExistsException {
        if (!validator.check(dto)) {
            throw new InvalidRequestException();
        }

        PoolDto pool = poolService.findById(dto.getPoolName());
        if (pool != null) {
            TrackDto foundTrack = pool.getTrackList().
                    stream().
                    filter((TrackDto trackDto) -> Objects.equals(trackDto.getNumber(), dto.getNumber())).
                    findFirst().
                    orElse(null);
            if (foundTrack == null) {
                trackService.insert(dto);
            } else {
                throw new ObjectAlreadyExistsException();
            }
        } else {
            throw new InvalidRequestException();
        }
    }

    public void fullUpdate(TrackDto dto) throws UpdateObjectNotExistException, InvalidRequestException, ObjectAlreadyExistsException {
        if (!validator.check(dto) && dto.getId() != null) {
            throw new InvalidRequestException();
        }

        PoolDto pool = poolService.findById(dto.getPoolName());
        if (pool != null) {
            if (trackService.findById(dto.getId()) != null) {
                TrackDto foundTrack = pool.getTrackList().
                        stream().
                        filter((TrackDto trackDto) -> Objects.equals(trackDto.getNumber(), dto.getNumber())).
                        findFirst().
                        orElse(null);
                if (foundTrack == null) {
                    trackService.update(dto);
                } else {
                    throw new ObjectAlreadyExistsException();
                }
            } else {
                throw new UpdateObjectNotExistException();
            }
        } else {
            throw new InvalidRequestException();
        }
    }

    public boolean delete(Integer key) throws InvalidRequestException {
        if (key != null) {
            return trackService.delete(key);
        }

        throw new InvalidRequestException();
    }
}
