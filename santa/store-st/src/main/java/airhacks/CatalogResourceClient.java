package airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("catalog")
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface CatalogResourceClient {
    
    @GET
    String catalog();
}
