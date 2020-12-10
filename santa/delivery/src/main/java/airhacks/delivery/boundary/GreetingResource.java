package airhacks.delivery.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import airhacks.catalog.control.Catalog;
import airhacks.catalog.control.CatalogResourceClient;

@Path("deliveries")
public class GreetingResource {

    @Inject
    Catalog catalog;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy -> " + this.catalog.catalog();
    }
}