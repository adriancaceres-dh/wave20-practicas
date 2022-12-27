package com.bootcamp.calculadoraCalorias.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    String name;
    int weightInGrams;

    public RequestDTO(String name, int grWeight) {
        this.name = name;
        this.weightInGrams = grWeight;
    }

    public RequestDTO() {
    }


}
