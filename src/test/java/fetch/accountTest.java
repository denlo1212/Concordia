package fetch;

import backend.model.Medewerker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.*;

public class accountTest {
    Medewerker medewerker1;
    Medewerker medewerker3;

    @BeforeEach
    public void init(){

        medewerker1 = new Medewerker("john@example.com", "password1");
        Medewerker medewerker2 = new Medewerker("jane@example.com", "password2");
        medewerker3 = new Medewerker("david@example.com", "password3");

        ArrayList<Medewerker> medewerkers = new ArrayList<>();
        medewerkers.addAll(Arrays.asList(medewerker1, medewerker2));

        Medewerker.setAlleMedewerkers(medewerkers);
    }


    @Test
    public void checkUserLoginTrue(){
        assertTrue(medewerker1.authenticateUser());
    }

    @Test
    public void checkUserLoginFalse(){
        assertFalse(medewerker3.authenticateUser());
    }


}
