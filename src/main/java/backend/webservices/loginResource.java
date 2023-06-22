package backend.webservices;

import backend.model.Medewerker;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.Date;
import java.util.List;

@Path("login")
public class loginResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            try {
                Jws<Claims> claims = Jwts.parser().setSigningKey("your_secret_key").parseClaimsJws(token);

                boolean signatureValid = claims.getBody().getSubject() != null;

                boolean tokenExpired = claims.getBody().getExpiration().before(new Date());

                if (signatureValid && !tokenExpired) {
//                    String username = (String) claims.getBody().get("email");
//                    String password = (String) claims.getBody().get("password");
//
//                    Medewerker medewerker = new Medewerker(username,password);
                    return Response.ok("User retrieved successfully").build();
                } else {
                    return Response.status(Response.Status.UNAUTHORIZED).build();
                }
            } catch (ExpiredJwtException e) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("JWT has expired").build();

            } catch (Exception e) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid JWT").build();
            }
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response generateToken(Medewerker medewerker) {

        boolean isAuthenticated = medewerker.authenticateUser();

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
