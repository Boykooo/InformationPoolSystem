package rest;


import Entities.Pool;
import services.PoolService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public List<Pool> getAllPools(){
        return service.findAll();
    }

    @GET
    @Path("/{poolId}")
    public Response getSpecificPool(@PathParam("poolId") int poolId){
        Pool user = service.findById(poolId);

        return (user == null) ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.ok(user).build();
    }


}
