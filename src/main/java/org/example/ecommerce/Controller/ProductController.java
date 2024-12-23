package org.example.ecommerce.Controller;


import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product= productService.getProductById(id);
        ResponseEntity responseEntity;
        if(product == null) {
            responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



    @GetMapping()
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return productService.replaceProductById(id, product);
    }
}
