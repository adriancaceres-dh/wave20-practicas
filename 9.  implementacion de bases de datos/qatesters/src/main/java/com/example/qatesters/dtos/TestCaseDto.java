package com.example.qatesters.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseDto {
  private Long idCase;

  private String description;

  private Boolean tested;

  private Boolean passed;

  private Integer numberOfTries;

  private LocalDate lastUpdate;
}
