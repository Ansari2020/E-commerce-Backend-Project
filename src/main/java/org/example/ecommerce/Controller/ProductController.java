package org.example.ecommerce.Controller;


import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( "/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
        //return new Product();
    }



    @GetMapping()
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        return products;
    }
}
