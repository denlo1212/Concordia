package backend.model;

import java.util.ArrayList;

public class Resevering {

    private String datum;
    private int aantal;
    private String tijd;
    private static ArrayList<Resevering> alleReseveringen = new ArrayList<Resevering>();

    public Resevering(String datum, String uren, int aantal) {
        this.datum = datum;
        this.aantal = aantal;
        this.tijd = uren;
        alleReseveringen.add(this);
    }

    public String  getDatum() {
        return datum;
    }

    public String getTijd() {
        return tijd;
    }


    public int getAantal() {
        return aantal;
    }

    public static ArrayList<Resevering> getAlleReseveringen() {
        return alleReseveringen;
    }

    public static void  setAlleReseveringen(ArrayList<Resevering> dataAlleReseveringen) {
        alleReseveringen = dataAlleReseveringen;
    }
}
