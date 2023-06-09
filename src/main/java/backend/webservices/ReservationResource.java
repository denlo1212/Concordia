package backend.webservices;

import backend.model.Resevering;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("reservation")
public class ReservationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        return Response.ok(Resevering.getAlleReseveringen()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReservation(String requestBody){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Resevering resevering= gson.fromJson(requestBody, Resevering.class);

        Resevering newResevering = new Resevering(
                resevering.getDatum(),
                resevering.getTijd(),
                resevering.getAantal());

        return Response.ok(newResevering).build();
    }

}
