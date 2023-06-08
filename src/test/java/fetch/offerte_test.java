package fetch;

import backend.model.Offerte;
import backend.webservices.OfferteResource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class offerte_test {
    @BeforeEach
    public void init(){

    }

    @Test
    public void testCreateOfferte() {
        // Create a sample JSON request body
        String requestBody = "{\"naam\":\"John Doe\",\"telefoonnummer\":\"123456789\",\"type_feest\":\"Birthday\",\"email\":\"john@example.com\",\"datum\":\"2023-06-08\",\"aantal\":50,\"overig\":\"Some additional information\"}";

        // Create an instance of OfferteResource
        OfferteResource offerteResource = new OfferteResource();

        // Call the createOfferte method
        Response response = offerteResource.createOfferte(requestBody);

        // Assert that the response status is OK
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        for(Offerte offerte: Offerte.getAlleOffertes()){
            System.out.println(offerte.getTelefoonnummer());
            assertEquals("John Doe", offerte.getNaam());
            assertEquals(123456789, offerte.getTelefoonnummer());
            assertEquals("Birthday", offerte.getType_feest());
            assertEquals("john@example.com", offerte.getEmail());
            assertEquals("2023-06-08", offerte.getDatum());
            assertEquals(50, offerte.getAantal());
            assertEquals("Some additional information", offerte.getOverig());
        }
    }
}

