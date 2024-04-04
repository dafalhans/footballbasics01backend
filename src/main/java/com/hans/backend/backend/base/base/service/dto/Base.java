package com.hans.backend.backend.base.base.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Base {

    private String id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}