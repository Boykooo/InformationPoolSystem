package controllers;

import Exceptions.ObjectAlreadyExistsException;
import Exceptions.ReferenceNotFoundException;
import Validation.DataValidator;
import dto.PoolDto;
import dto.TrackDto;
import services.PoolService;
import services.TrackService;

import javax.ejb.EJB;
import javax.ws.rs.BadRequestException;
import java.util.Objects;

public class TrackController {

    @EJB
    private TrackService service;
    @EJB
    private DataValidator validator;
    @EJB
    private PoolService poolService;

    public void addNewTrack(TrackDto dto){
        if (validator.check(dto)){
            PoolDto pool = poolService.findById(dto.getPoolName());
            if (pool != null) {
                TrackDto foundTrack = pool.getTrackList().
                        stream().
                        filter((TrackDto trackDto) -> Objects.equals(trackDto.getNumber(), dto.getNumber())).
                        findFirst().
                        orElse(null);
                if (foundTrack == null) {
                    dao.insert(convertToEntity(dto));
                } else {
                    throw new ObjectAlreadyExistsException();
                }
            } else {
                throw new ReferenceNotFoundException(dto.getPoolName());
            }
        }

        throw new BadRequestException();
    }
}
