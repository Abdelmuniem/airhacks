package airhacks.catalog.control;

import javax.inject.Inject;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
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

    @CircuitBreaker
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "tooSlow")
    @SimplyTimed(tags = "layer=control")
    public String catalog() {
        var estimate = this.estimator.behavior();
        System.out.println(" " + estimate);
        var name = this.client.catalog();
        return name.getString("name", "nothing");
    }

    public String tooSlow() {
        return "santa is too slow";
    }
}
