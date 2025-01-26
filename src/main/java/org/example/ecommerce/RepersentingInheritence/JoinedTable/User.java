package org.example.ecommerce.RepersentingInheritence.JoinedTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
//it will create table for parent as well child and use fk in child
@Entity(name = "jt_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
