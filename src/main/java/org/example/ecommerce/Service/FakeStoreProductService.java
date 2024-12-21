package org.example.ecommerce.Service;

import org.example.ecommerce.DTO.FakeStoreProductDto;
import org.example.ecommerce.Model.Category;
import org.example.ecommerce.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product fakeStoreProductDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setDescription(dto.getDescription());


        Category category = new Category();
        category.setDescription(dto.getCategory());
        product.setCategory(category);
        return product;

    }



    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto=
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDto==null)
            return null;

        return fakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
