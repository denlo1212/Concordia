package backend.model;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;

public class Offerte {
    private String naam;
    private int telefoonnummer;
    private String bruiloft;
    private String email;
    private Date datum;
    private int aantal;
    private String overig;
    private static ArrayList<Offerte> alleOffertes = new ArrayList<Offerte>();

    public Offerte(String naam, int telefoonnummer, String bruiloft, String email, Date datum, int aantal, String overig) {
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
        this.bruiloft = bruiloft;
        this.email = email;
        this.datum = datum;
        this.aantal = aantal;
        this.overig = overig;
        alleOffertes.add(this);
    }

    public String getNaam() {
        return naam;
    }

    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getBruiloft() {
        return bruiloft;
    }

    public String getEmail() {
        return email;
    }

    public Date getDatum() {
        return datum;
    }

    public int getAantal() {
        return aantal;
    }

    public String getOverig() {
        return overig;
    }

    public static ArrayList<Offerte> getAlleOffertes() {
        return alleOffertes;
    }

    public static void  setAlleOffertes(ArrayList<Offerte> dataAlleOffertes) {
        alleOffertes = dataAlleOffertes;
    }
}
