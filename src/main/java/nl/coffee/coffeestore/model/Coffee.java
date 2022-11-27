package nl.coffee.coffeestore.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Coffee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    private String id;
    private String name;

    public Coffee(){
    }
    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Coffee(String name){
        this(UUID.randomUUID().toString(),name);
    }
    public String getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }
}
