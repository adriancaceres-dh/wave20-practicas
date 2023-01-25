package com.example.QATesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {

    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    private Integer numberOfTries;

    private LocalDate lastUpdate;

}
