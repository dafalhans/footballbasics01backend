package com.hans.backend.backend.appl.actors.business;

import com.hans.backend.backend.appl.utils.BasePositionEnum;

import lombok.Data;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "TBL_Player")
@TableGenerator(
        name = "PlayerEntityTableGenerator",
        table = "PlayerEntity_id_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
        allocationSize = 1
)
@ToString(callSuper = true)
@Data
public class PlayerEntity extends ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PlayerEntityTableGenerator")
    private Long id;

    private int weight;
    private int height;

    @Enumerated(EnumType.STRING)
    private BasePositionEnum basePosition;  // standaard plaats op het veld (los van overrulled positie tijdens een match)
    private int shirtNumber; // TODO: 1 --> 11 ?? of gaat dit nog verder?

//    @Lob
//    @Column(columnDefinition = "bytea")  // TODO : waarom geen BLOB? Is dit een postgres ding?

    private byte[] playerImageData;

    private String nationality;

//    @ToString.Exclude
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "team_id")
//    private TeamEntity team;

}
