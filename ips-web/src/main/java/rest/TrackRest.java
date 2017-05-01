package rest;

import controllers.TrackController;
import dto.TrackDto;
import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import rest.Responses.AbstractResponse;
import rest.Responses.ErrorResponse;
import rest.Responses.NotFoundResponse;
import rest.Responses.SuccessfulResponse;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tracks")
@Produces("text/json")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class TrackRest {

    @EJB
    private TrackController service;

    @GET
    public List<TrackDto> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{trackId}")
    public Response getSpecificTrack(@PathParam("trackId") Integer trackId) {
        AbstractResponse response;
        try {
            return Response.ok(service.findById(trackId)).build();
        } catch (InvalidRequestException e) {
            return Response.ok(new ErrorResponse(e.getMessage())).build();
        }
    }

    @POST
    public Response addTrack(
            @FormParam("number") Integer number,
            @FormParam("poolName") String poolName) {

        AbstractResponse response;
        try {
            service.insert(new TrackDto(null, number, poolName));
            response = new SuccessfulResponse();
        } catch (ObjectAlreadyExistsException | InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @PUT
    public Response updateTrack(
            @FormParam("id") Integer id,
            @FormParam("number") Integer number,
            @NotNull @FormParam("poolName") String poolName) {

        AbstractResponse response;
        if (id != null) {
            try {
                service.fullUpdate(new TrackDto(id, number, poolName));
                response = new SuccessfulResponse();
            } catch (UpdateObjectNotExistException | InvalidRequestException | ObjectAlreadyExistsException e) {
                response = new ErrorResponse(e.getMessage());
            }
        } else {
            response = new ErrorResponse("Required field id cannot be null");
        }

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") Integer id) {
        AbstractResponse response;
        try {
            response = (service.delete(id)) ? new SuccessfulResponse() : new NotFoundResponse();
        } catch (InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

}
