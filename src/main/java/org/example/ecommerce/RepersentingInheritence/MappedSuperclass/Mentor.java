package org.example.ecommerce.RepersentingInheritence.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_mentor")
public class Mentor extends User{
    private double mentorRating;
}
