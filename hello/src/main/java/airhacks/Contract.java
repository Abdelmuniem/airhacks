package airhacks;

import javax.enterprise.context.Dependent;

@Dependent
public interface Contract {
    
    void execute();
}
