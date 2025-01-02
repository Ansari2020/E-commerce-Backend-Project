package org.example.ecommerce.Controller;


import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
//        ResponseEntity<Product> response=null;
//        try {
//            Product product = productService.getProductById(id);
//            response = new ResponseEntity<>(product, HttpStatus.OK);
//
//        }
//        catch (ArithmeticException e) {
//            response= new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return response;
        Product product= productService.getProductById(id);
        ResponseEntity<Product> responseEntity;
//        if(product == null) {
//            responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//            return responseEntity;
//        }
        return new ResponseEntity<>(product, HttpStatus.OK);

    }



    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products= productService.getAllProducts();
        ResponseEntity responseEntity;
        if(products == null) {
            responseEntity = new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        return new ResponseEntity<>(products, HttpStatus.OK);


    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {

        Product product2= productService.getProductById(id);
        ResponseEntity responseEntity;
        if(product2==null) {
            responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        Product product1= productService.replaceProductById(id, product);

        return new ResponseEntity<>(product1,HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product= productService.getProductById(id);
        ResponseEntity responseEntity;
        if(product==null) {
            responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1= productService.addProduct(product);
        ResponseEntity responseEntity;
        return new ResponseEntity<>(product1,HttpStatus.CREATED);


    }

    @GetMapping()
    public List<Product> getProductByLimit(@RequestParam Integer limit) {
        return productService.getProductByLimit(limit);
    }
}
