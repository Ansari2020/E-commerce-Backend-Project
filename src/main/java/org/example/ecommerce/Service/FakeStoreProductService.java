package org.example.ecommerce.Service;

import org.example.ecommerce.DTO.FakeStoreProductDto;
import org.example.ecommerce.Model.Category;
import org.example.ecommerce.Model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
        // we will use array to get the resopnse from api instead of list bcz of type eraser.
        FakeStoreProductDto[] fakeStoreProductDtos=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class); // .class is used for get type of class
        //System.out.println("DEBUG");
        List<Product> response=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            response.add(fakeStoreProductDtoToProduct(fakeStoreProductDto));

        }
        return response;


    }

    @Override
    public Product replaceProductById(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);

        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =

                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,restTemplate.getMessageConverters());
        FakeStoreProductDto response=
                restTemplate.execute("https://fakestoreapi.com/products/"+id,
                HttpMethod.PUT, requestCallback, responseExtractor);
        return fakeStoreProductDtoToProduct(response);
    }
}
