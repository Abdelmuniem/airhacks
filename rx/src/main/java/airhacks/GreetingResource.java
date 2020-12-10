package airhacks;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;



@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    @Channel("coffee")
    Emitter<String> channel;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void save(String payload) {
        this.channel.send(payload);
    }
}