package backend.model;

import java.util.ArrayList;

public class Medewerker {
    private String naam;
    private String woonplaats;
    private String email;
    private String wachtwoord;
    private static ArrayList<Medewerker> alleMedewerkers = new ArrayList<Medewerker>();

    public Medewerker(String naam, String woonplaats, String email, String wachtwoord) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.email = email;
        this.wachtwoord = wachtwoord;
        alleMedewerkers.add(this);
    }

    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public static ArrayList<Medewerker> getAlleMedewerkers() {
        return alleMedewerkers;
    }
}
