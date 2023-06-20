package test;

import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;

import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Medewerker medewerker1 = new Medewerker( "john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker( "jane@example.com", "password2");
        Medewerker medewerker3 = new Medewerker( "david@example.com", "password3");

        Offerte offerte1 = new Offerte("John Doe", 123456789, "Bruiloft", "test@gmail.com", "2024-06-06", 100, "Extra decorations");
        Offerte offerte2 = new Offerte("Jane Smith", 987654321, "Bruiloft","test@gmail.com", "2024-06-06", 50, "Photography services");
        Offerte offerte3 = new Offerte("David Johnson", 555555555, "Bruiloft", "test@gmail.com", "2024-06-06", 200, "Live music band");

        Resevering resevering1 = new Resevering("2024-06-06","15:30", 5);
        Resevering resevering2 = new Resevering("2024-06-06", "15:30",10);
        Resevering resevering3 = new Resevering("2024-06-06", "15:30",3);

        for (Resevering resevering : Resevering.getAlleReseveringen()) {
            System.out.println("Datum: " + resevering.getDatum());
            System.out.println("Aantal: " + resevering.getAantal());
            System.out.println("---------------------------------");
        }

        System.out.println(new Date());
    }
}
