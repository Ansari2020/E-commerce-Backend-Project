package org.example.ecommerce.RepersentingInheritence.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("3")
@Entity(name = "st_ta") /// it will not create table but store attribute in user
public class TA extends User {
    private int numberOfSession;
    private double averageRating;
}
