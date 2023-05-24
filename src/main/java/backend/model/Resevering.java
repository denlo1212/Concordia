package backend.model;

import java.util.ArrayList;
import java.util.Date;

public class Resevering {
    Date datum;
    Date tijd;
    int aantal;
    static ArrayList<Resevering> alleReseveringen = new ArrayList<Resevering>();

    public Resevering(Date datum, Date tijd, int aantal) {
        this.datum = datum;
        this.tijd = tijd;
        this.aantal = aantal;
        alleReseveringen.add(this);
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

    public static ArrayList<Resevering> getAlleReseveringen() {
        return alleReseveringen;
    }
}
