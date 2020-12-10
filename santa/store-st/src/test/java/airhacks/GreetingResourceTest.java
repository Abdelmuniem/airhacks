package airhacks;

import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;




@QuarkusTest
public class GreetingResourceTest {

    @Inject
    @RestClient
    CatalogResourceClient resourceClient;

    @Test
    public void catalog() {
        var catalog = this.resourceClient.catalog();
        System.out.println("GreetingResourceTest.enclosing_method() " + catalog);
    }

}