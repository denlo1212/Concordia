package backend.webservices;

import backend.model.Resevering;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("reservation")
public class ReservationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReseveringen(){
        return Response.ok(Resevering.getAlleReseveringen()).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReservation(Resevering resevering){
        Resevering newResevering = new Resevering(resevering.getDatum(),resevering.getTijd(),resevering.getAantal());
        Resevering.getAlleReseveringen().add(newResevering);
        return Response.ok(newResevering).build();
    }

}
