package nl.coffee.coffeestore.controller;

import nl.coffee.coffeestore.model.Coffee;
import nl.coffee.coffeestore.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/*@Controller
@ResponseBody*/
// or
@RestController
@RequestMapping("coffee.nl/coffees")
public class CoffeeController {
    //Test to use internal variable greeting-name
    //    @Value("${greeting-name}")
    @Value("${greeting-name: Cleveland}")
    private String greetingName;
    @Value("${welcome-phrase}")
    private String greetingPhrase;

    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcomePage(@RequestParam(name = "username") String username){
//        return "Welcome to the shop, "+username;

        return greetingPhrase;
    }

    @GetMapping("/greetings")
    public String greetingPage()
    {
        System.out.println(SingleCoffeeOwner.getInstance("StarBucks"));
        return "Welcome to the shop, "+greetingName;
    }

    @GetMapping
    public Iterable<Coffee> getAllCoffees(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Coffee>> getCoffeeById(@PathVariable String id){
        return new ResponseEntity<>(coffeeRepository.findById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee){
        return new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Coffee> putCoffee(@RequestBody Coffee coffee){
        return coffeeRepository.existsById(coffee.getId())==true ? new ResponseEntity<>(coffeeRepository.save(coffee),HttpStatus.OK):new ResponseEntity<>(coffeeRepository.save(coffee) , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

final class SingleCoffeeOwner{
    private String owner_name="Starbucks";
    private static SingleCoffeeOwner instance;
    private SingleCoffeeOwner(String owner_name){
        this.owner_name=owner_name;
    }

    public static SingleCoffeeOwner getInstance(String owner_name){
        if(instance==null){
            SingleCoffeeOwner.instance=new SingleCoffeeOwner(owner_name);
            System.out.println("Entity created");
        }
        else {
            System.out.println("Entity exist");
        }
        return instance;
    }
}