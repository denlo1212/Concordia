package backend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Date;

public class Medewerker {
    private String username;
    private String password;
    private static ArrayList<Medewerker> alleMedewerkers = new ArrayList<>();

    public Medewerker(@JsonProperty("username") String username,
                      @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Medewerker> getAlleMedewerkers() {
        return alleMedewerkers;
    }

    public static void setAlleMedewerkers(ArrayList<Medewerker> dataAlleMedewerkers) {
        alleMedewerkers = dataAlleMedewerkers;
    }

    public boolean authenticateUser() {
        for (Medewerker medewerker : alleMedewerkers) {
            if (username.equals(medewerker.getUsername()) && password.equals(medewerker.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String generateJWTToken() {
        String signingKey = "your_secret_key";
        int expirationMinutes = 60;

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expirationMinutes * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();

        return token;
    }

    public static boolean isUserLoggedIn(String jwtToken, String secretKey) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            Claims claims = claimsJws.getBody();
            
            if (claims.getExpiration().before(new Date())) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}



//@JsonIgnoreProperties(ignoreUnknown = true)
//public class aaa {
//    private String naam;
//    private String woonplaats;
//    private String email;
//    private String wachtwoord;
//    private static ArrayList<aaa> alleMedewerkers = new ArrayList<aaa>();
//
//    public aaa(@JsonProperty("naam") String naam,
//               @JsonProperty("woonplaats") String woonplaats,
//               @JsonProperty("email") String email,
//               @JsonProperty("wachtwoord") String wachtwoord) {
//        this.naam = naam;
//        this.woonplaats = woonplaats;
//        this.email = email;
//        this.wachtwoord = wachtwoord;
//    }
//
//    public String getNaam() {
//        return naam;
//    }
//
//    public String getWoonplaats() {
//        return woonplaats;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getWachtwoord() {
//        return wachtwoord;
//    }
//
//    public static ArrayList<Medewerker> getAlleMedewerkers() {
//        return alleMedewerkers;
//    }
//
//    public static void setAlleMedewerkers(ArrayList<Medewerker> dataAlleMedewerkers) {
//        alleMedewerkers = dataAlleMedewerkers;
//    }
//}

