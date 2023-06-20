package backend.webservices;

import backend.model.Offerte;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("offerte")
public class OfferteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        return Response.ok(Offerte.getAlleOffertes()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOfferte(Offerte offerte) {

        Offerte newOfferte = new Offerte(
                offerte.getNaam(),
                offerte.getTelefoonnummer(),
                offerte.getType_feest(),
                offerte.getEmail(),
                offerte.getDatum(),
                offerte.getAantal(),
                offerte.getOverig()
        );

        Offerte.getAlleOffertes().add(newOfferte);

        return Response.ok(newOfferte).build();
    }
}
