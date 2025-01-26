package org.example.ecommerce.RepersentingInheritence.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("1")
@Entity(name = "st_instructor")
public class Instructor extends User {
    private String specialization;
}
