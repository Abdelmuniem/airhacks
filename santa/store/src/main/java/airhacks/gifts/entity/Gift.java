package airhacks.gifts.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Gift {

    @Schema(readOnly = true)
    public long id;
    @Schema(example = "keyboard")
    public String name;

    @Schema(example="13")
    public int price;
    
    public Gift(String name, int price) {
        this.id = System.currentTimeMillis();
        this.name = name;
        this.price = price;
    }
    
    public Gift() {
    }
    
    
}
