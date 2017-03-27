package rest;


import Entities.User;
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
    UserService service;

    public UserRest() {
    }

    @GET
    public List<User> getAllUsers(){
        return service.findAll();
    }

    @GET
    @Path("/{userEmail}")
    public Response getSpecificUsers(@PathParam("userEmail") String userEmail){
        User user = service.findById(userEmail);

        return (user == null) ? Response.status(Response.Status.NOT_FOUND).build()
                              : Response.ok(user).build();
    }

    @GET
    @Path("/test")
    public String test(){
        return "Hello";
    }
}
