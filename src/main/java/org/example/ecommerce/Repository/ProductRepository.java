package org.example.ecommerce.Repository;

import org.example.ecommerce.Model.Category;
import org.example.ecommerce.Model.Product;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByCategory(Category category);
    List<Product> findByTitle(String title);
    List<Product> findByDescription(String description);

    void delete(Product product);
    Product save(Product product);
}
