package org.example;

import backend.model.Resevering;

import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Resevering resevering1 = new Resevering(new Date(), new Date(), 5);
        Resevering resevering2 = new Resevering(new Date(), new Date(), 10);
        Resevering resevering3 = new Resevering(new Date(), new Date(), 3);

        for (Resevering resevering : Resevering.getAlleReseveringen()) {
            System.out.println("Datum: " + resevering.getDatum());
            System.out.println("Tijd: " + resevering.getTijd());
            System.out.println("Aantal: " + resevering.getAantal());
            System.out.println("---------------------------------");
        }
    }
}
