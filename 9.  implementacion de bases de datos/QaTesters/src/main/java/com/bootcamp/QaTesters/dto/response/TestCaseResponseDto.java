package com.bootcamp.QaTesters.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseResponseDto {
    @JsonProperty("id_case")
    private Long idCase;
    private String description;
    private boolean tested;
    private boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
