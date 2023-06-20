package backend.utils;





import backend.model.Medewerker;
import backend.model.Offerte;
import backend.model.Resevering;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DataManager<T> {


    public void loadData() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("src/assets/classData/Data.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<T> objects=new ArrayList<>();
        objects = (ArrayList<T>) ois.readObject();


        ArrayList<Medewerker> alleMedewerkers = (ArrayList<Medewerker>) objects.get(0);
        ArrayList<Offerte> alleOffertes = (ArrayList<Offerte>) objects.get(1);
        ArrayList<Resevering> alleReseveringen = (ArrayList<Resevering>) objects.get(2);

        Medewerker.setAlleMedewerkers(alleMedewerkers);
        Offerte.setAlleOffertes(alleOffertes);
        Resevering.setAlleReseveringen(alleReseveringen);

        ois.close();
    }

    public void saveData(T obj, T obj2, T obj3) throws IOException {
        ArrayList<T> objects=new ArrayList<>();

        OutputStream fos = Files.newOutputStream(Path.of("src/assets/Data.obj"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        objects.add(obj);
        objects.add(obj2);
        objects.add(obj3);
        oos.writeObject(objects);

        oos.close();
    }

    public static void saveAll() throws IOException {
        DataManager dm = new DataManager();
        dm.saveData(
                Medewerker.getAlleMedewerkers(),
                Offerte.getAlleOffertes(),
                Resevering.getAlleReseveringen()
        );
    }
}

