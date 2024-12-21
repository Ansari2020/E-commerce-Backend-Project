package org.example.ecommerce.Service;

import org.example.ecommerce.Model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);
    List<Product> getAllProducts();
}
