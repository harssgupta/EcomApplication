package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.register.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
