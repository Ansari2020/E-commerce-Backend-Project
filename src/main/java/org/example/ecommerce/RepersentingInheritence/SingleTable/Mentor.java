package org.example.ecommerce.RepersentingInheritence.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("2")
@Entity(name = "st_mentor")
public class Mentor extends User {
    private double mentorRating;
}
