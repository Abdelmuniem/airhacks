package airhacks;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class Developer {
    
    @Incoming("coffee")
    @Outgoing("code")
    public String process(String drink) {
        System.out.println("Developer: " + drink);
        return "2 lines of Java with: " + drink;
    }
}
