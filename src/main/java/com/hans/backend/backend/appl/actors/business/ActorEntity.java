package com.hans.backend.backend.appl.actors.business;

import com.hans.backend.backend.base.base.business.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@MappedSuperclass
//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)// should be empty
@Data
public class ActorEntity extends BaseEntity<Long> {

    private String firstName;
    private String lastName;
//    private LocalDateTime birthDate;
    private LocalDate birthDate;

}
