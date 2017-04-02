package rest;


import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import dto.PoolDto;
import rest.Responses.AbstractResponse;
import rest.Responses.ErrorResponse;
import rest.Responses.NotFoundResponse;
import rest.Responses.SuccessfulResponse;
import services.PoolService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pools")
@Produces("text/json")
public class PoolRest {

    @EJB
    private PoolService service;

    public PoolRest() {
        service = new PoolService();
    }

    @GET
    public List<PoolDto> getAllPools() {
        return service.findAll();
    }

    @GET
    @Path("/{poolName}")
    public Response getSpecificPool(@PathParam("poolName") String poolName) {
        PoolDto poolDto = service.findById(poolName);

        return (poolDto == null) ? Response.ok(new NotFoundResponse()).build()
                : Response.ok(poolDto).build();
    }

    @POST
    public Response addPool(
            @FormParam("name") String name,
            @FormParam("length") String length,
            @FormParam("width") String width,
            @FormParam("depth") String depth,
            @FormParam("type") String type,
            @FormParam("isWorking") Boolean isWorking) {

        AbstractResponse response;
        if (name != null) {
            try {
                service.insert(new PoolDto(name, length, width, depth, type, isWorking));
                response = new SuccessfulResponse();
            } catch (ObjectAlreadyExistsException e) {
                response = new ErrorResponse(e.getMessage());
            }
        } else {
            response = new ErrorResponse("Required field name cannot be null");
        }

        return Response.ok(response).build();
    }

    @PUT
    public Response updatePool(@FormParam("name") String name,
                               @FormParam("length") String length,
                               @FormParam("width") String width,
                               @FormParam("depth") String depth,
                               @FormParam("type") String type,
                               @FormParam("isWorking") Boolean isWorking) {
        AbstractResponse response;
        if (name != null) {
            try {
                service.update(new PoolDto(name, length, width, depth, type, isWorking));
                response = new SuccessfulResponse();
            } catch (UpdateObjectNotExistException e) {
                response = new ErrorResponse(e.getMessage());
            }
        }
        else {
            response = new ErrorResponse("Required field name cannot be null");
        }

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{poolName}")
    public Response deletePool(@PathParam("poolName") String name) {
        AbstractResponse response;
        if (name != null){
            service.delete(name);
            response = new SuccessfulResponse();
        }
        else {
            response = new ErrorResponse("Required field name cannot be null");
        }

        return Response.ok(response).build();
    }
}
