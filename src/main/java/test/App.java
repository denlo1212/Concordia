package test;

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
// ?name=danilo&type_zaal=partij&phone=06-348-73-298&email=iets%40gmail.com&
// date=2023-05-10T10%3A24&
// aantal=12&
// overig=overig&
// submit_button=

//            http://localhost:63342/Concordia/src/main/webapp/offerte/offerte_pagina.html?
            // name=danilo&
            // type_zaal=partij&p
            // hone=06-348-73-298&
            // email=iets%40gmail.com&
            // date=2023-05-20T10%3A37&
            // aantal=123&
            // overig=ivear&submit_button=#
        }
    }
}
