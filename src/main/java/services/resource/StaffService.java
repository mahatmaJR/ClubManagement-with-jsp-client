package services.resource;

import com.google.gson.Gson;
import models.Staff;
import org.hibernate.annotations.GeneratorType;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/staff")
public class StaffService {

    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result = "Your getting to know how to use REST but you need to be able to diversify";

        return Response.status(200).entity(result).build();
    }

}
