package backend.model;

import java.util.ArrayList;
import java.util.Date;

public class Offerte {
    private String naam;
    private int telefoonnummer;
    private String bruiloft;
    private Date datum;
    private Date tijd;
    private int aantal;
    private String overig;
    private static ArrayList<Offerte> alleOffertes = new ArrayList<Offerte>();

    public Offerte(String naam, int telefoonnummer, String bruiloft, Date datum, Date tijd, int aantal, String overig) {
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
        this.bruiloft = bruiloft;
        this.datum = datum;
        this.tijd = tijd;
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

    public Date getDatum() {
        return datum;
    }

    public Date getTijd() {
        return tijd;
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
}
