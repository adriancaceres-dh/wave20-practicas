package com.bootcamp.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PatentBrandModelEconomicLossDTO extends PatentDTO {

    private String brand;
    private String model;
    @JsonProperty("economic_loss")
    private Double economicLoss;
}
