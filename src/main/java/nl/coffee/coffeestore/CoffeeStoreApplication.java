package nl.coffee.coffeestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication

//next annotation enables spring to scan for classes with @ConfigurationProperties
//this is done to configure project with configuration classes directly bend to application.properties
@ConfigurationPropertiesScan
public class CoffeeStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeStoreApplication.class, args);
    }

}
