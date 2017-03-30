package rest;


import dto.PoolDto;
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
    public List<PoolDto> getAllPools(){
        return service.findAll();
    }

    @GET
    @Path("/{poolName}")
    public Response getSpecificPool(@PathParam("poolName") String poolName){
        PoolDto poolDto = service.findById(poolName);

        return (poolDto == null) ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.ok(poolDto).build();
    }
}
