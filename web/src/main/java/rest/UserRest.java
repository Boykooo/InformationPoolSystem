package rest;


import Entities.User;
import services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserRest {

    UserService service;

    public UserRest() {
        service = new UserService();
    }

    @GET
    @Produces("text/json")
    public List<User> getAllUsers(){
        return service.findAll();
    }

    @GET
    @Produces("text/json")
    @Path("/{userId}")
    public Response getSpecificUsers(@PathParam("userId") int userId){
        User user = service.findById(userId);

        return (user == null) ? Response.status(Response.Status.NOT_FOUND).build()
                              : Response.ok(user).build();
    }

    @GET
    @Path("/test")
    public String test(){
        return "Hello";
    }
}
