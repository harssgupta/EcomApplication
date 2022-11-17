package com.project.ecomapplication.repository;
import com.project.ecomapplication.entities.register.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer>
{
  Optional<Roles> findByAuthority(String name);
}
