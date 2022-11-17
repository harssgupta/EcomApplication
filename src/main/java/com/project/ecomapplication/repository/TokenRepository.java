package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.register.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Integer> {

    Token findBytoken(String activationToken);
}
