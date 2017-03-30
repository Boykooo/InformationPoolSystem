package rest;


import Exceptions.EmailException;
import Exceptions.UpdateObjectNotExistException;
import dto.UserDto;
import rest.Responses.AbstractResponse;
import rest.Responses.ErrorResponse;
import rest.Responses.SuccessfulResponse;
import services.UserService;

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
    private UserService service;

    public UserRest() {
    }

    @GET
    public List<UserDto> getAllUsers() {
        return service.findAll();
    }

    @GET
    @Path("/{userEmail}")
    public Response getSpecificUsers(@PathParam("userEmail") String userEmail) {
        UserDto userDto = service.findById(userEmail);

        return (userDto == null) ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.ok(userDto).build();
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
            service.insert(buildUserDto(email, firstName, lastName, phoneNumber, password));
            response = new SuccessfulResponse();
        } catch (EmailException e) {
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
            service.update(buildUserDto(email, firstName, lastName, phoneNumber, password));
            response = new SuccessfulResponse();
        } catch (UpdateObjectNotExistException e) {
            response = new ErrorResponse(e.getMessage());
        }

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{userEmail}")
    public Response deleteUser(@PathParam("userEmail") String email) {
        service.delete(email);
        return Response.ok(new SuccessfulResponse()).build();
    }

    private UserDto buildUserDto(String email, String firstName, String lastName, String phoneNumber, String password) {
        UserDto dto = new UserDto();
        dto.setEmail(email);
        dto.setPhoneNumber(phoneNumber);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPassword(password);

        return dto;
    }

}