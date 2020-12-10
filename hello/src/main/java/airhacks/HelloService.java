package airhacks;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

@Dependent
public class HelloService {


    public String hello() {
        return "good morning!";
    }

    
}
