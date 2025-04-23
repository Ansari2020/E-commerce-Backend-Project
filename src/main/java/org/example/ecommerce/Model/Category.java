package org.example.ecommerce.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{

    private String description;
//    @OneToMany(mappedBy = "category") //(fetch = FetchType.EAGER)
//    private List<Product> products;


}
