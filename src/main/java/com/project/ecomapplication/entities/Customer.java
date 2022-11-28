package com.project.ecomapplication.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@Table(name="customer")
public class Customer extends User {

    private String contact;

}
