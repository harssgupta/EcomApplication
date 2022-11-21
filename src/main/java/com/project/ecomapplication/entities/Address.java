package com.project.ecomapplication.entities;
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
    private Long id;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String addressLine;
    private String label;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @Override
    public String toString() {
        return "\tCity: " + city + "\n\tState: " + state + "\n\tCountry: " + country + "\n\tAddress Line: " + addressLine + "\n\tZip Code: " + zipcode;
    }

    public void setAddress(String address) {
    }
}