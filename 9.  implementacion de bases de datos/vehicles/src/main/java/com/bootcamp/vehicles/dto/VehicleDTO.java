package com.bootcamp.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    private String patent;
    private String brand;
    private String model;
    @JsonProperty("production_year")
    private Integer productionYear;
    @JsonProperty("wheel_count")
    private Integer wheelCount;
}
