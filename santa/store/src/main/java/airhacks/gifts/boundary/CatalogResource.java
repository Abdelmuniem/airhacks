package airhacks.gifts.boundary;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;

import airhacks.gifts.entity.Gift;

@Counted(tags = {"layer=boundary"})
@Path("catalog")
public class CatalogResource {
    

    @Inject
    @ConfigProperty(name = "default-gift",defaultValue = "nothing")
    String gift;


    @Fallback(fallbackMethod = "overloaded")
    @GET
    @Bulkhead(value = 2,waitingTaskQueue = 2)
    @Produces(MediaType.APPLICATION_JSON)
    public Gift gifts() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        return new Gift(this.gift, 13);
    }
    
    public Gift overloaded() {
        return new Gift("no", -1);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Gift gift) {
        System.out.println("CatalogResource.save() " + gift);
    }
}
