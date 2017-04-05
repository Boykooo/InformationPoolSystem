package rest;


import Exceptions.InvalidRequestException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.UpdateObjectNotExistException;
import controllers.PoolController;
import dto.PoolDto;
import rest.Responses.AbstractResponse;
import rest.Responses.ErrorResponse;
import rest.Responses.SuccessfulResponse;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pools")
@Produces("text/json")
public class PoolRest {

    @EJB
    private PoolController service;

    public PoolRest() {
    }

    @GET
    public List<PoolDto> getAllPools() {
        return service.findAll();
    }

    @GET
    @Path("/{poolName}")
    public Response getSpecificPool(@PathParam("poolName") String poolName) {
        AbstractResponse response;
        try {
            return Response.ok(service.findById(poolName)).build();
        } catch (InvalidRequestException e) {
            return Response.ok(new ErrorResponse(e.getMessage())).build();
        }
    }

    @POST
    public Response addPool(
            @FormParam("name") String name,
            @FormParam("length") Double length,
            @FormParam("width") Double width,
            @FormParam("depth") Double depth,
            @FormParam("type") String type,
            @FormParam("isWorking") Boolean isWorking) {

        AbstractResponse response;

        try {
            service.insert(new PoolDto(name, length, width, depth, type, isWorking));
            response = new SuccessfulResponse();
        } catch (InvalidRequestException | ObjectAlreadyExistsException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @PUT
    public Response updatePool(@FormParam("name") String name,
                               @FormParam("length") Double length,
                               @FormParam("width") Double width,
                               @FormParam("depth") Double depth,
                               @FormParam("type") String type,
                               @FormParam("isWorking") Boolean isWorking) {
        AbstractResponse response;
        try {
            service.update(new PoolDto(name, length, width, depth, type, isWorking));
            response = new SuccessfulResponse();
        } catch (InvalidRequestException | UpdateObjectNotExistException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{poolName}")
    public Response deletePool(@PathParam("poolName") String name) {
        AbstractResponse response;
        try {
            service.delete(name);
            response = new SuccessfulResponse();
        } catch (InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }


        return Response.ok(response).build();
    }
}
