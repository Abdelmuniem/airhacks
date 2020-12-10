package airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    HelloService hs;

    @Inject
    Contract contract;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        contract.execute();
        return "Hello RESTEasy " + this.hs.hello();
    }
}