package com.project.ecomapplication.entities.register;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userID")
    private UserEntity userEntity;
}
