package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.register.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>
{
    Optional<UserEntity> findByemail(String email);
    Boolean existsByemail(String email);


}
