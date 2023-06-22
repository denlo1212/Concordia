package model;

import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class model_test {
    Medewerker medewerker;
    Offerte offerte;
    Resevering resevering;

    @BeforeEach
    public void init(){
        medewerker.getAlleMedewerkers().clear();
        offerte.getAlleOffertes().clear();
        resevering.getAlleReseveringen().clear();

        Medewerker medewerker1 = new Medewerker("john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker("jane@example.com", "password2");
        Medewerker medewerker3 = new Medewerker("david@example.com", "password3");

        ArrayList<Medewerker> medewerkers = new ArrayList<>();
        medewerkers.addAll(Arrays.asList(medewerker1, medewerker2, medewerker3));

        Medewerker.setAlleMedewerkers(medewerkers);

        Offerte offerte1 = new Offerte("John Doe", 123456789, "Bruiloft", "test@gmail.com", "2024-06-06", 100, "Extra decorations");
        Offerte offerte2 = new Offerte("Jane Smith", 987654321, "Bruiloft","test@gmail.com", "2024-06-06", 50, "Photography services");
        Offerte offerte3 = new Offerte("David Johnson", 555555555, "Bruiloft", "test@gmail.com", "2024-06-06", 200, "Live music band");
        ArrayList<Offerte> offertes = new ArrayList<>();
        offertes.addAll(Arrays.asList(offerte1, offerte2, offerte3));

        Offerte.setAlleOffertes(offertes);

        Resevering resevering1 = new Resevering("2024-06-06", "15:30", 5);
        Resevering resevering2 = new Resevering("2024-06-06", "15:30", 10);
        Resevering resevering3 = new Resevering("2024-06-06", "15:30", 3);

        ArrayList<Resevering> reseveringen = new ArrayList<>();
        reseveringen.addAll(Arrays.asList(resevering1, resevering2, resevering3));

        Resevering.setAlleReseveringen(reseveringen);
    }

    @Test
    void aantalMedewerkers(){
        assertEquals(3,medewerker.getAlleMedewerkers().size());
    }

    @Test
    void aantalOffertes(){
        assertEquals(3,offerte.getAlleOffertes().size());
    }

    @Test
    void aantalReseveringen(){
        assertEquals(3,resevering.getAlleReseveringen().size());
    }


}


