package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.TokenDelete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDeleteRepository extends JpaRepository<TokenDelete,Long> {

   TokenDelete findByTokenEquals(String token);


}
