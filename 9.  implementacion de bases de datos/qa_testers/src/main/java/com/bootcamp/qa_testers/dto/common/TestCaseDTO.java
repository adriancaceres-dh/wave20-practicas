package com.bootcamp.qa_testers.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class TestCaseDTO {

    @JsonProperty("id_case")
    private Long idCase;
    private  String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate lastUpdate;
}
