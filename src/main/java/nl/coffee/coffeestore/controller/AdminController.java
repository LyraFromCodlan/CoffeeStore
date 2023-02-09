package nl.coffee.coffeestore.controller;

import nl.coffee.coffeestore.postConfig.WebManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final WebManager webManager;

    public AdminController(WebManager webManager) {
        this.webManager = webManager;
    }

    @GetMapping("/manager_info")
    public WebManager getWebManager(){
        return webManager;
    }
}
