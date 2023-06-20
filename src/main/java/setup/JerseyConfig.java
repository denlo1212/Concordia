package setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("concordia")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("backend.webservices");
    }




}
