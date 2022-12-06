package nl.coffee.coffeestore.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

//Configuration class annotated with @ConfigurationProperties to help define and assign config variables
//Must contain getters and setters
//Better have prefix
@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String greetingName;
    private String greetingPhrase;
    private String storeName;

    public Greeting(){}

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }

    public void setGreetingPhrase(String greetingPhrase) {
        this.greetingPhrase = greetingPhrase;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGreetingName() {
        return greetingName;
    }

    public String getGreetingPhrase() {
        return greetingPhrase;
    }

    public String getStoreName() {
        return storeName;
    }
}
