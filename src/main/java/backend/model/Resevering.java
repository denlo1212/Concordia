package backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Resevering {

    private String datum;
    private String tijd;
    private int aantal;
    private static ArrayList<Resevering> alleReseveringen = new ArrayList<Resevering>();

    public Resevering(@JsonProperty("naam")String datum,
                      @JsonProperty("tijd")String tijd,
                      @JsonProperty("aantal")int aantal) {
        this.datum = datum;
        this.tijd = tijd;
        this.aantal = aantal;
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
