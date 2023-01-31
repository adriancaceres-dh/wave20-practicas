package com.bootcamp.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PatentBrandYearDTO extends PatentDTO {

    private String brand;
    @JsonProperty("production_year")
    private Integer productionYear;
}
