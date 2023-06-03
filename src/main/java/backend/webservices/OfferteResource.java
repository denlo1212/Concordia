package backend.webservices;

import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.OfferteDateDeserializer;


import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.util.Date;


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
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new OfferteDateDeserializer());
        Gson gson = gsonBuilder.setDateFormat(DateFormat.FULL, DateFormat.FULL).create();

        Offerte offerte = gson.fromJson(requestBody, Offerte.class);

        Offerte newOfferte = new Offerte(
                offerte.getNaam(),
                offerte.getTelefoonnummer(),
                offerte.getBruiloft(),
                offerte.getEmail(),
                offerte.getDatum(),
                offerte.getAantal(),
                offerte.getOverig()
        );

        return Response.ok(newOfferte).build();
    }
}
