package airhacks;

import java.time.LocalDateTime;

import io.quarkus.scheduler.Scheduled;

@Control
public class PackageDispatcher {

    //@Scheduled(every = "2s")
    public void ship() {
        System.out.println("shipping " + LocalDateTime.now());
    }
    
}
