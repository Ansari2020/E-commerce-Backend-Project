package org.example.ecommerce.Service;

import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProductById(Long id, Product product);
    void deleteProductById(Long id);
    Product addProduct(Product product);

    List<Product> getProductByLimit(Integer limit);
}
