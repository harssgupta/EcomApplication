package com.project.ecomapplication.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "category_metadata_field")
@Data
public class CategoryMetadataField {

    @SequenceGenerator(name = "category_metadata_field_sequence", sequenceName = "category_metadata_field_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category_metadata_field_sequence")
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}