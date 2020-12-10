package airhacks.delivery.boundary;

import javax.enterprise.context.Dependent;

import org.eclipse.microprofile.opentracing.Traced;

@Traced
@Dependent
public class GiftEstimator {
    
    public String behavior() {
        try {
			Thread.sleep(280);
		} catch (InterruptedException e) {
		}
        return "nice!";
    }
}
