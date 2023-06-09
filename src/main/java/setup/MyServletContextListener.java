package setup;


import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;
import utils.DataManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    DataManager dataManager = new DataManager();

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        Medewerker medewerker1 = new Medewerker("John Doe", "Amsterdam", "john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker("Jane Smith", "Rotterdam", "jane@example.com", "password2");
        Medewerker medewerker3 = new Medewerker("David Johnson", "The Hague", "david@example.com", "password3");

        Offerte offerte1 = new Offerte("John Doe", 123456789, "Bruiloft", "test@gmail.com", "2024-06-06", 100, "Extra decorations");
        Offerte offerte2 = new Offerte("Jane Smith", 987654321, "Bruiloft","test@gmail.com", "2024-06-06", 50, "Photography services");
        Offerte offerte3 = new Offerte("David Johnson", 555555555, "Bruiloft", "test@gmail.com", "2024-06-06", 200, "Live music band");

        Resevering resevering1 = new Resevering("2024-06-06","15:30", 5);
        Resevering resevering2 = new Resevering("2024-06-06", "15:30",10);
        Resevering resevering3 = new Resevering("2024-06-06", "15:30",3);


//        try {
//            dataManager.loadData();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Initializing application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        try {
//            dataManager.saveAll();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        System.out.println("Terminating application");
    }

}
