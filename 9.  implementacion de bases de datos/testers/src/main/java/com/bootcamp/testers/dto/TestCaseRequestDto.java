package com.bootcamp.testers.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter @Getter
public class TestCaseRequestDto {
    private String description;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
