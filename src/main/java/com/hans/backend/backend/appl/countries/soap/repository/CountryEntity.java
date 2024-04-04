package com.hans.backend.backend.appl.countries.soap.repository;


import com.hans.backend.backend.base.base.business.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_Contry")
@TableGenerator(
        name = "CountryEntityTableGenerator",
        table = "CountryEntity_id_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
        allocationSize = 1
)
@Data
public class CountryEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CountryEntityTableGenerator")
    private Long id;

}
