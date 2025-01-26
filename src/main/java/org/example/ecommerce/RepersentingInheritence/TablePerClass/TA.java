package org.example.ecommerce.RepersentingInheritence.TablePerClass;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TA extends User {
    private int numberOfSession;
    private double averageRating;
}
