package com.hans.backend.backend.appl.teams.business;

import com.hans.backend.backend.base.base.business.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TBL_Team")
@TableGenerator(
        name = "TeamEntityTableGenerator",
        table = "TeamEntity_id_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
        allocationSize = 1
)
@Data
public class TeamEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TeamEntityTableGenerator")
    private Long id;

    private String teamName;
    private String location;
    private String stadiumName;
    private byte[] teamLogoImageData;

//    private List<Long> playerIds;
    private Long trainerId;

//    @OneToMany
//    @JoinColumn(name = "gameId")
//    private List<CardEntity> cards;

}
