package airhacks.catalog.control;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("catalog")
@RegisterRestClient(configKey = "store")
public interface CatalogResourceClient {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response catalog();
}
