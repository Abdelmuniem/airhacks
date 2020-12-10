package airhacks;

import java.security.Principal;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

@PermitAll
@Path("/hello-resteasy")
public class GreetingResource {


    @Inject
    Principal principal;

    @Inject
    JsonWebToken token;

    @GET
    @RolesAllowed("airhacker")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy " + this.principal.getName() + " and groups " + token.getGroups();
    }
}