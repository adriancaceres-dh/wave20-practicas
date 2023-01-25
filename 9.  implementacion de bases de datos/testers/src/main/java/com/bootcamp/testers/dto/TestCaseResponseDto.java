package com.bootcamp.testers.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class TestCaseResponseDto {
    private Long idCase;
    private String description;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
