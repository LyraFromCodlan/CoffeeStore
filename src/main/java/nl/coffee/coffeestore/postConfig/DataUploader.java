package nl.coffee.coffeestore.postConfig;

import nl.coffee.coffeestore.model.Coffee;
import nl.coffee.coffeestore.repository.CoffeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

//this component is used to upload pre-existing data on start-up of the app
//to disable data upload comment @Component
@Component
public class DataUploader {
    private final CoffeeRepository coffeeRepository;

    public DataUploader(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void UploadData(){
        coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas"),
                new Coffee("Rebusta"),
                new Coffee("Liberia"),
                new Coffee("Arabica")
        ));
    }
}
