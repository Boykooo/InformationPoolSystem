package rest;


import exceptions.InvalidRequestException;
import exceptions.ObjectAlreadyExistsException;
import exceptions.UpdateObjectNotExistException;
import controllers.UserController;
import dto.UserDto;
import rest.Responses.AbstractResponse;
import rest.Responses.ErrorResponse;
import rest.Responses.SuccessfulResponse;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces("text/json")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class UserRest {

    @EJB
    private UserController service;

    public UserRest() {
    }

    @GET
    public List<UserDto> getAllUsers() {
        return service.findAll();
    }

    @GET
    @Path("/{userEmail}")
    public Response getSpecificUsers(@PathParam("userEmail") String userEmail) {
        AbstractResponse response;
        try {
            return Response.ok(service.findById(userEmail)).build();
        } catch (InvalidRequestException e) {
            return Response.ok(new ErrorResponse(e.getMessage())).build();
        }
    }

    @POST
    public Response addUser(
            @FormParam("email") String email,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("phoneNumber") String phoneNumber,
            @FormParam("password") String password) {

        AbstractResponse response;
        try {
            service.insert(new UserDto(email, firstName, lastName, phoneNumber, password));
            response = new SuccessfulResponse();
        } catch (ObjectAlreadyExistsException | InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @PUT
    public Response updateUser(
            @FormParam("email") String email,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("phoneNumber") String phoneNumber,
            @FormParam("password") String password) {

        AbstractResponse response;

        try {
            service.fullUpdate(new UserDto(email, firstName, lastName, phoneNumber, password));
            response = new SuccessfulResponse();
        } catch (UpdateObjectNotExistException | InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{userEmail}")
    public Response deleteUser(@PathParam("userEmail") String email) {
        AbstractResponse response;

        try {
            service.delete(email);
            response = new SuccessfulResponse();
        } catch (InvalidRequestException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }
}