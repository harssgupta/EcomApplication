package com.project.ecomapplication.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User {

   //private Integer userId foreign key
    private String gstNumber;
    private String companyContact;
    private String companyName;


 public Seller(User user, String gstNumber, String companyContact, String companyName) {

 }
}
