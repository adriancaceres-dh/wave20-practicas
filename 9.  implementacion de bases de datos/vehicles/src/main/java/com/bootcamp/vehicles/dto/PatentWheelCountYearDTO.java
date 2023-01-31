package com.bootcamp.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PatentWheelCountYearDTO extends PatentDTO {

    private Integer wheelCount;
    @JsonProperty("production_year")
    private Integer productionYear;
}
