package com.project.ecomapplication.entities.register;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String firstName;
     private String middleName;
     private String lastName;
     private String username;
     private String email;
     private String password;
     private boolean isDeleted;
     private boolean isActive;
     private boolean isExpired;
     private boolean isLocked;
     private Integer invalidAttemptCount;
  //   private LocalDate passwordUpdateDate;

     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<Address> addresses;

     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)//want to fetch everything
     @JoinTable(name="user_role",joinColumns = @JoinColumn(name="userID" ,referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name="roleID",referencedColumnName = "id"))
     private List<Roles> roles;


}
