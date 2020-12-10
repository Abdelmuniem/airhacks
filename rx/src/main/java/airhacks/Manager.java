package airhacks;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Manager {
    

    @Incoming("code")
    public void sink(String code) {
        System.out.println("Manager: " + code);
    }
}
