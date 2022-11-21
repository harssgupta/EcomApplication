package com.project.ecomapplication.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@Table(name="customer")
public class Customer extends User {

    private String contact;

    public Customer(User user, String contact) {

    }
}
