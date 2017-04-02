package rest;

import Exceptions.ObjectAlreadyExistsException;
import Exceptions.ReferenceNotFoundException;
import Exceptions.UpdateObjectNotExistException;
import dto.TrackDto;
import rest.Responses.*;
import services.TrackService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tracks")
@Produces("text/json")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class TrackRest {

    @EJB
    private TrackService service;

    @GET
    public List<TrackDto> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{trackId}")
    public Response getAll(@PathParam("trackId") Integer trackId) {
        TrackDto dto = service.findById(trackId);
        return (dto == null) ? Response.ok(new NotFoundResponse()).build()
                : Response.ok(dto).build();
    }

    @POST
    public Response addTrack(
            @FormParam("number") Integer number,
            @FormParam("poolName") String poolName) {

        AbstractResponse response;
        try {
            service.insert(new TrackDto(null, number, poolName));
            response = new SuccessfulResponse();
        } catch (ObjectAlreadyExistsException | ReferenceNotFoundException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @PUT
    public Response updateTrack(
            @FormParam("id") Integer id,
            @FormParam("number") Integer number,
            @FormParam("poolName") String poolName) {

        AbstractResponse response;
        if (id != null) {
            try {
                service.update(new TrackDto(id, number, poolName));
                response = new SuccessfulResponse();
            } catch (UpdateObjectNotExistException | ReferenceNotFoundException | ObjectAlreadyExistsException e) {
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
        if (id != null){
            response = (service.delete(id)) ? new SuccessfulResponse() : new NotFoundResponse();
        }
        else {
            response = new CannotBeNullResponse("id");
        }

        return Response.ok(response).build();
    }

}
