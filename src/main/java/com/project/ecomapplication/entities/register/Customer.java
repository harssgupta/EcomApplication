package com.project.ecomapplication.entities.register;

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
public class Customer extends UserEntity {

    private Integer phoneNumber;



}
