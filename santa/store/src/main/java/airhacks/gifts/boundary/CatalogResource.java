package airhacks.gifts.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;

@Counted(tags = {"layer=boundary"})
@Path("catalog")
public class CatalogResource {
    

    @Inject
    @ConfigProperty(name = "default-gift",defaultValue = "nothing")
    String gift;


    @GET
    public String gifts() {
        return this.gift;
    }
}
