package backend.model;

import java.util.ArrayList;

public class Offerte {
    private String naam;
    private int telefoonnummer;
    private String type_feest;
    private String email;
    private String datum;
    private int aantal;
    private String overig;
    private static ArrayList<Offerte> alleOffertes = new ArrayList<Offerte>();

    public Offerte(String naam, int telefoonnummer, String bruiloft, String email, String datum, int aantal, String overig) {
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
        this.type_feest = bruiloft;
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

    public String getType_feest() {
        return type_feest;
    }

    public String getEmail() {
        return email;
    }

    public String getDatum() {
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
