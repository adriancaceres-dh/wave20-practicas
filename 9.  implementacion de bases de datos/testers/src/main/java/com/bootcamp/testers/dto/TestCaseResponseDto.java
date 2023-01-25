package com.bootcamp.testers.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TestCaseResponseDto {
    private Long idCase;
    private String description;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
