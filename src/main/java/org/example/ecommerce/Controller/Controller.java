package org.example.ecommerce.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Controller {

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return "Showing product";
    }
}
