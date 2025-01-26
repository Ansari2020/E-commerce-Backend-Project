package org.example.ecommerce.Service;

import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Projection.findByTileAndDescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProductById(Long id, Product product);
    Product updateProductById(Long id, Product product);
    Product createProduct(Product product);
    void deleteProduct(Long id);
    public List<Product> getProductByLimit(Integer limit);

    //HQL
    @Query("SELECT p.title AS title, p.description as description from Product p where p.id=:id")
    findByTileAndDescription someRandommethod(@Param("id") Long id);

    @Query(value = "select title, description form product where id= :id", nativeQuery = true)
    Product someRandomSqlQuery(@Param("id") Long id);


}
