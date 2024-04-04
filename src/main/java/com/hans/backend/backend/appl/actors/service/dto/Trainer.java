package com.hans.backend.backend.appl.actors.service.dto;

import com.hans.backend.backend.base.base.service.dto.Base;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
public class Trainer extends Base {


    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private String trainerSpecialty;

}