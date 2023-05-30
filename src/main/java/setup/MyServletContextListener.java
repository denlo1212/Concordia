package setup;


import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;
import utils.DataManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Date;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    DataManager dataManager = new DataManager();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Medewerker medewerker1 = new Medewerker("John Doe", "Amsterdam", "john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker("Jane Smith", "Rotterdam", "jane@example.com", "password2");

        Offerte offerte1 = new Offerte("John Doe", 123456789, "Bruiloft", new Date(), new Date(), 100, "Extra details 1");
        Offerte offerte2 = new Offerte("Jane Smith", 987654321, "Verjaardag", new Date(), new Date(), 50, "Extra details 2");

        Resevering resevering1 = new Resevering(new Date(), new Date(), 100);
        Resevering resevering2 = new Resevering(new Date(), new Date(), 50);


        try {
            dataManager.loadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Initializing application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            dataManager.saveAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Terminating application");
    }

}
