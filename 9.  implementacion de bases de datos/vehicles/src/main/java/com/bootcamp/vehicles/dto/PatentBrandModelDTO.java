package com.bootcamp.vehicles.dto;

import lombok.Getter;

@Getter
public class PatentBrandModelDTO extends PatentBrandDTO {

    private final String model;

    public PatentBrandModelDTO(String patent, String brand, String model) {
        super(patent, brand);
        this.model = model;
    }
}
