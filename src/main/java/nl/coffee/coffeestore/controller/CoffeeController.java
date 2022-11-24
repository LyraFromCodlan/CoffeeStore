package nl.coffee.coffeestore.controller;

import nl.coffee.coffeestore.model.Coffee;
import nl.coffee.coffeestore.repository.CoffeeRepository;
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

    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas"),
                new Coffee("Rebusta"),
                new Coffee("Liberia"),
                new Coffee("Arabica")
        ));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcomePage(@RequestParam(name = "username") String username){
        return "Welcome to the shop, "+username;
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
