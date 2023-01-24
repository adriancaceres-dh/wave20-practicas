package com.example.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;

}
