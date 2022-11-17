package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.register.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    Seller findByemail(String email);
    Boolean existsByemail(String email);
}
