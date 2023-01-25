package com.bootcamp.qa_testers.qa_testers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {

    private Long idCase;
    private String description;
    private boolean tested;
    private boolean passed;
    private Integer numberOfTries;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate lastUpdate;
}
