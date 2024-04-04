package com.hans.backend.backend.appl.actors.service.dto;

import com.hans.backend.backend.base.base.service.dto.Base;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
public class Player extends Base {

    private String firstName;
    private String lastName;
//    private String birthDate;
    private LocalDate birthDate;

    private int weight;
    private int height;

    private String basePosition;
    private int shirtNumber;

    private String playerImageData;


}