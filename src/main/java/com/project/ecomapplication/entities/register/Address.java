package com.project.ecomapplication.entities.register;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;
    private String state;
    private String country;
    private Integer zipcode;
    private String label;

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserEntity user;

}
