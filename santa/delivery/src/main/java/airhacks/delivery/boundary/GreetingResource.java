package airhacks.delivery.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import airhacks.Boundary;
import airhacks.catalog.control.Catalog;
import io.quarkus.runtime.Startup;

@Boundary
@Path("deliveries")
public class GreetingResource {

    @Inject
    Catalog catalog;

    //migration of @Startup @Singleton
    @Startup
    public void name() {
        System.out.println("start me up");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy -> " + this.catalog.catalog();
    }
}