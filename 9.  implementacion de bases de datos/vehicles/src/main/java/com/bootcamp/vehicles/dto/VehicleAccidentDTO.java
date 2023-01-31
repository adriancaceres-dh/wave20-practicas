package com.bootcamp.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class VehicleAccidentDTO {

    private VehicleDTO vehicle;
    @JsonProperty("economic_loss")
    private Double economicLoss;
}
