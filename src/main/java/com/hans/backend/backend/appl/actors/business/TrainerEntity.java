package com.hans.backend.backend.appl.actors.business;

import com.hans.backend.backend.appl.utils.TrainerSpecialty;
import com.hans.backend.backend.base.base.business.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "TBL_Trainer")
@TableGenerator(
        name = "TrainerEntityTableGenerator",
        table = "TrainerEntity_id_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
        allocationSize = 1
)
@ToString(callSuper = true)
@Data
public class TrainerEntity extends ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TrainerEntityTableGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TrainerSpecialty trainerSpecialty;

}
