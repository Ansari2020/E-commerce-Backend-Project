package org.example.ecommerce.RepersentingInheritence.MappedSuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta")
public class TA extends User{
    private int numberOfSession;
    private double averageRating;
}
