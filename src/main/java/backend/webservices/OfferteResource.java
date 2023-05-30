package backend.webservices;

import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;
import com.google.gson.Gson;


import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("test")
public class OfferteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        return Response.ok(Medewerker.getAlleMedewerkers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOfferte(String requestBody){

        Gson gson = new Gson();
        Offerte offerte = gson.fromJson(requestBody, Offerte.class);

        Offerte newOfferte = new Offerte(
                offerte.getNaam(),
                offerte.getTelefoonnummer(),
                offerte.getBruiloft(),
                offerte.getDatum(),
                offerte.getTijd(),
                offerte.getAantal(),
                offerte.getOverig()
        );

        return Response.ok(newOfferte).build();
    }
}
