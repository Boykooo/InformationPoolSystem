package rest;


import dto.UserDto;
import services.UserService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces("text/json")
public class UserRest {

    @EJB
    private UserService service;

    public UserRest() {
    }

    @GET
    public List<UserDto> getAllUsers(){
        return service.findAll();
    }

    @GET
    @Path("/{userEmail}")
    public Response getSpecificUsers(@PathParam("userEmail") String userEmail){
        UserDto userDto = service.findById(userEmail);

        return (userDto == null) ? Response.status(Response.Status.NOT_FOUND).build()
                              : Response.ok(userDto).build();
    }


}