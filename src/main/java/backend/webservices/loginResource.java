package backend.webservices;

import backend.model.Medewerker;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("login")
public class loginResource {

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@Context HttpHeaders headers) {
        List<String> authorizationHeaders = headers.getRequestHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
            String authorizationHeader = authorizationHeaders.get(0);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7); // Remove "Bearer " prefix

                String secretKey = SecretKeyProvider.getSecretKey();

                boolean loggedIn = Medewerker.isUserLoggedIn(token, secretKey);

                if (loggedIn) {
                    String username = medewerker.getUsername();
                    return Response.ok(username).build();
                } else {
                    return Response.status(Response.Status.UNAUTHORIZED).build();
                }
            }
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response generateToken(Medewerker medewerker) {

        System.out.println("leuk printje voor de medewerker");

        boolean isAuthenticated = medewerker.authenticateUser();

        System.out.println(medewerker);
        System.out.println(medewerker.getUsername());

        if (isAuthenticated) {
            String token = medewerker.generateJWTToken();
            System.out.println(token);
            return Response.ok()
                    .entity(new AbstractMap.SimpleEntry<>("jwt", token))
                    .build();

        }

        else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
