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
    public Response createOfferte(String requestBody) {

        System.out.println(requestBody);

        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setDateFormat("yyyy-MM-dd");
//        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Gson gson = gsonBuilder.create();

        Offerte offerte = gson.fromJson(requestBody, Offerte.class);

        Offerte newOfferte = new Offerte(
                offerte.getNaam(),
                offerte.getTelefoonnummer(),
                offerte.getType_feest(),
                offerte.getEmail(),
                offerte.getDatum(),
                offerte.getAantal(),
                offerte.getOverig()
        );

        return Response.ok(newOfferte).build();
    }
}
