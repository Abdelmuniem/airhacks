package airhacks.catalog.control;

import javax.inject.Inject;

import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import airhacks.Control;

@Control
public class Catalog {
    
    @Inject
    @RestClient
    CatalogResourceClient client;

    @SimplyTimed(tags = "layer=control")
    public String catalog() {
        var name = this.client.catalog();
        return name.getString("name", "nothing");
    }
}
