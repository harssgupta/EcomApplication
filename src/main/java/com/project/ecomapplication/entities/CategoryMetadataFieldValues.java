package com.project.ecomapplication.entities;

import com.project.ecomapplication.services.ListToStringConverter;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class CategoryMetadataFieldValues {

    @SequenceGenerator(name = "category_metadata_field_values_sequence", sequenceName = "category_metadata_field_values_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_metadata_field_id")
    CategoryMetadataField categoryMetadataField;

    @Convert(converter = ListToStringConverter.class)
    private Set<String> valueList;
}