package com.example.QATesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
