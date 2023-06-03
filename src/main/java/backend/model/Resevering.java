package backend.model;

import java.util.ArrayList;
import java.util.Date;

public class Resevering {
    private Date datum;
    private int aantal;
    private static ArrayList<Resevering> alleReseveringen = new ArrayList<Resevering>();

    public Resevering(Date datum, int aantal) {
        this.datum = datum;
        this.aantal = aantal;
        alleReseveringen.add(this);
    }

    public Date getDatum() {
        return datum;
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
