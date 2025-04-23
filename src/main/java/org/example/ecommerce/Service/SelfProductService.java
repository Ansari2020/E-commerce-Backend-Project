package org.example.ecommerce.Service;


import org.example.ecommerce.Exception.ProductNotFoundException;
import org.example.ecommerce.Model.Category;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Projection.findByTileAndDescription;
import org.example.ecommerce.Repository.CategoryRepository;
import org.example.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
@Primary
public class SelfProductService implements ProductService {
    private final ProductService productService;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
             ProductService productService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException(id,"Product not found");
        }
        return product.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber, pageSize,
                Sort.by("price").ascending().
                        and(Sort.by("title").descending())));
    }


    @Override
    public Product updateProductById(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(id,"Product not found");
        }
        Product productToUpdate = productOptional.get();
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCategory(product.getCategory());
        productRepository.save(productToUpdate);
        return productToUpdate;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
//        if(category.getId() == null) {
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
        Product savedProduct=productRepository.save(product);
        Optional<Category> optionalCategory=categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1=optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> getLimitedProducts(Integer limit) {
        return productRepository.findAll().subList(0, limit);
    }

    public findByTileAndDescription findByTileAndDescription(@Param("id") Long id) {
        return productRepository.someRandommethod(id);
    }

}
