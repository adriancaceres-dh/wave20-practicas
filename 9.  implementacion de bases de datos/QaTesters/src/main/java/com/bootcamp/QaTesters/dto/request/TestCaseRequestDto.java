package com.bootcamp.QaTesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TestCaseRequestDto {
    @JsonProperty("id_case")
    private Long idCase;
    private String description;
    private boolean tested;
    private boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate lastUpdate;
}
