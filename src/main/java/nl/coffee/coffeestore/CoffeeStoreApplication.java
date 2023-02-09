package nl.coffee.coffeestore;

import nl.coffee.coffeestore.postConfig.WebManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//next annotation enables spring to scan for classes with @ConfigurationProperties
//this is done to configure project with configuration classes directly bend to application.properties
@ConfigurationPropertiesScan
public class CoffeeStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeStoreApplication.class, args);
    }
    @Bean
    @ConfigurationProperties(prefix = "manager")
    public WebManager createWebManager(){
        return new WebManager();
    }
}
