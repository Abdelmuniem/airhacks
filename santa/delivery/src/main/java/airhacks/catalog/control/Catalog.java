package airhacks.catalog.control;

import javax.inject.Inject;
import javax.json.JsonObject;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricRegistry.Type;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import airhacks.Control;
import airhacks.delivery.boundary.GiftEstimator;

@Control
public class Catalog {
    
    @Inject
    @RestClient
    CatalogResourceClient client;

    @Inject
    GiftEstimator estimator;

    @Inject
    @RegistryType(type = Type.APPLICATION)
    MetricRegistry registry;

    @CircuitBreaker
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "tooSlow")
    @SimplyTimed(tags = "layer=control")
    public String catalog() {
        var estimate = this.estimator.behavior();
        System.out.println(" " + estimate);
        var response = this.client.catalog();
        var status = response.getStatus();
        registry.counter("store_communication_status_" + status).inc();
        var name = response.readEntity(JsonObject.class);
        if (status != 200)
            return "...";
        return name.getString("name", "nothing");
    }

    public String tooSlow() {
        return "santa is too slow";
    }
}
