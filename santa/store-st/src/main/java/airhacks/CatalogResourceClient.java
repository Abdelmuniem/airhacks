package airhacks;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("catalog")
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface CatalogResourceClient {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    JsonObject catalog();
}
