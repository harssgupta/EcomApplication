package com.project.ecomapplication.entities.order;

import com.project.ecomapplication.entities.register.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double amountPaid;
    private Date createdDate;
    private String paymentMethod;
    private String customerAddressCity;
    private String customerAddressState;
    private String customerAddressCountry;
    private String customerAddressLine;
    private int customerZipCode;
    private String CustomerAddressLabel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_User_Id")
    private Customer customer;

}