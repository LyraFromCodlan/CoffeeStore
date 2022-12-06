package nl.coffee.coffeestore.controller;

import nl.coffee.coffeestore.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
//    deprecated code that will be remastered with configuration class
//    @Value("${greeting-name: Cleveland}")
//    private String greetingName;
//    @Value("${welcome-phrase: Welcome to the store, ${greeting-name}!}")
//    private String greetingPhrase;
    private final Greeting greeting;

    public GreetingController(Greeting greeting){
        this.greeting=greeting;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcomePage(@RequestParam(name = "username") String username){
        return greeting.getGreetingPhrase();
    }

    @GetMapping("/greetings")
    public String greetingPage()
    {
        System.out.println(SingleCoffeeOwner.getInstance("StarBucks"));
        return "Welcome to the shop, "+greeting.getGreetingName();
    }
}
