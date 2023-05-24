package model;

import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class model_test {
    Medewerker medewerker;
    Offerte offerte;
    Resevering resevering;

    @BeforeEach
    public void init(){
        Medewerker medewerker1 = new Medewerker("John Doe", "Amsterdam", "john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker("Jane Smith", "Rotterdam", "jane@example.com", "password2");
        Medewerker medewerker3 = new Medewerker("David Johnson", "The Hague", "david@example.com", "password3");

        Offerte offerte1 = new Offerte("John Doe", 123456789, "Bruiloft", new Date(), new Date(), 100, "Extra decorations");
        Offerte offerte2 = new Offerte("Jane Smith", 987654321, "Bruiloft", new Date(), new Date(), 50, "Photography services");
        Offerte offerte3 = new Offerte("David Johnson", 555555555, "Bruiloft", new Date(), new Date(), 200, "Live music band");

        Resevering resevering1 = new Resevering(new Date(), new Date(), 5);
        Resevering resevering2 = new Resevering(new Date(), new Date(), 10);
        Resevering resevering3 = new Resevering(new Date(), new Date(), 3);
    }

    @Test
    void aantalMedewerkers(){
        assertEquals(9,medewerker.getAlleMedewerkers().size());
    }

    @Test
    void aantalOffertes(){
        assertEquals(3,offerte.getAlleOffertes().size());
    }

    @Test
    void aantalReseveringen(){
        assertEquals(6,resevering.getAlleReseveringen().size());
    }


}


