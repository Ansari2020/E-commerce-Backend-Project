package org.example.ecommerce.Controller;


import org.example.ecommerce.DTO.UserDto;
import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Projection.findByTileAndDescription;
import org.example.ecommerce.Repository.ProductRepository;
import org.example.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductRepository productRepository;
    private ProductService productService;
    //private AuthCommon authCommon;

    ProductController(@Qualifier("fakestoreproductservice") ProductService productService,
                      ProductRepository productRepository
                      ) {
        //AuthCommon authCommon
        this.productService = productService;
        this.productRepository = productRepository;
       // this.authCommon = authCommon;
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {


            //UserDto userDto = authCommon.validateToken(token);
            ResponseEntity<Product> responseEntity;

//            if (userDto == null) {
//                responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//                return responseEntity;
//            }
            Product product= productService.getProductById(id);
            return responseEntity=new ResponseEntity<>(product,HttpStatus.OK);


    }

    @GetMapping()
    public Page<Product> getProducts(@RequestParam("pageNumber") int pageNumber,
                                     @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNumber, pageSize);


    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {

        Product product2= productService.getProductById(id);
        ResponseEntity responseEntity;
        if(product2==null) {
            responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        Product product1= productService.updateProductById(id, product);

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
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) throws ProductNotFoundException {
        return productService.createProduct(product);

    }

//    localhost:8080/products?limit=2
//    @GetMapping()
//    public List<Product> getProductByLimit(@RequestParam(defaultValue = "2") Integer limit) {
//        return productService.getLimitedProducts(limit);
//    }

//    find some attributes with id
    @GetMapping("TD/{id}")
    public findByTileAndDescription findByTitleAndDescription(@PathVariable("id") Long id){
       findByTileAndDescription findByTileAndDescription=productRepository.someRandommethod(id);
       return findByTileAndDescription;
    }
}
