package com.bootcamp.qa_testers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCaseDTO {
    private Long caseId;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
