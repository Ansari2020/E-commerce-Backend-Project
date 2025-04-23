package org.example.ecommerce.Repository;

import org.example.ecommerce.Model.Category;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Projection.findByTileAndDescription;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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




    //HQL
    @Query("SELECT p.title AS title, p.description as description from Product p where p.id=:id")
    findByTileAndDescription someRandommethod(@Param("id") Long id);

    @Query(value = "select title, description form product where id= :id", nativeQuery = true)
    findByTileAndDescription someRandomSqlQuery(@Param("id") Long id);

    @Override
    Page<Product> findAll(Pageable pageable);
}
