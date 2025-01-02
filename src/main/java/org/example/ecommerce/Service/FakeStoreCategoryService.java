package org.example.ecommerce.Service;

import org.example.ecommerce.DTO.FakeStoreCategoryDto;
import org.example.ecommerce.Model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public List<Category> getAllCategory() {
        String[] fakeStoreCategoryDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                        String[].class);
        List<Category> categoryList = new ArrayList<>();

        long idCounter = 0;
        for(String dto : fakeStoreCategoryDtos){
            Category category=new Category();
            category.setId(++idCounter);
            category.setDescription(dto);
            categoryList.add(category);

        }
        return categoryList;

    }
}
