package rest;


import Entities.User;
import services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/users")
@Produces("text/json")
public class UserRest {

    @GET
    public List<User> getAllUsers(){
        UserService userService = new UserService();
        List<User> userList = userService.findAll();

        return userList;
    }

    @GET
    @Path("/test")
    public String test(){
        return "Hello";
    }
}
