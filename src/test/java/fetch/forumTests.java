package fetch;

import backend.model.Offerte;
import backend.model.Resevering;
import backend.webservices.OfferteResource;
import backend.webservices.ReservationResource;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class forumTests {
    @BeforeEach
    public void init(){

    }

    @Test
    public void testCreateOfferte() {
        // Create a sample JSON request body
        Offerte offerte1 = new Offerte("John Doe", 123456789, "Birthday", "john@example.com",
                "2023-06-08", 50, "Some additional information");

        // Create an instance of OfferteResource
        OfferteResource offerteResource = new OfferteResource();

        // Call the createOfferte method
        Response response = offerteResource.createOfferte(offerte1);

        // Assert that the response status is OK
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        Offerte offerte = (Offerte) response.getEntity();

            assertEquals("John Doe", offerte.getNaam());
            assertEquals(123456789, offerte.getTelefoonnummer());
            assertEquals("Birthday", offerte.getType_feest());
            assertEquals("john@example.com", offerte.getEmail());
            assertEquals("2023-06-08", offerte.getDatum());
            assertEquals(50, offerte.getAantal());
            assertEquals("Some additional information", offerte.getOverig());

    }

    @Test
    public void testResevering(){
        Resevering resevering = new Resevering("2024-06-06", "15:30", 3);
        ReservationResource resevationresource = new ReservationResource();
        Response response = resevationresource.createReservation(resevering);
        assertEquals(Response.Status.OK.getStatusCode() ,response.getStatus());
        Resevering resevering1 = (Resevering) response.getEntity();
        assertTrue(resevering.getDatum().equals(resevering1.getDatum()));

    }
}

