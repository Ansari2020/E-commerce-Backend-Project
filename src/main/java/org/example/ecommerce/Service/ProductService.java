package org.example.ecommerce.Service;

import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Projection.findByTileAndDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;
    Page<Product> getAllProducts(int pageNumber, int pageSize);
    Product updateProductById(Long id, Product product) throws ProductNotFoundException;
    Product createProduct(Product product);
    void deleteProduct(Long id);
    public List<Product> getLimitedProducts(Integer limit);



}
