package nl.coffee.coffeestore.repository;

import nl.coffee.coffeestore.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository  extends JpaRepository<Coffee, String> {
}
