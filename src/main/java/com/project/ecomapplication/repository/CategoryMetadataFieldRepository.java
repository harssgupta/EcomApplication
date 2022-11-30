package com.project.ecomapplication.repository;

import com.project.ecomapplication.entities.CategoryMetadataField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMetadataFieldRepository extends JpaRepository<CategoryMetadataField, Long> {

    @Query(value = "SELECT * FROM category_metadata_field a WHERE a.name = ?1", nativeQuery = true)
    CategoryMetadataField findByCategoryMetadataFieldName(String fieldName);
}
