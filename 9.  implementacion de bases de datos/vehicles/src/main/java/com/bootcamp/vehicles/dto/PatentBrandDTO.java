package com.bootcamp.vehicles.dto;

import lombok.Getter;

@Getter
public class PatentBrandDTO extends PatentDTO {

    private final String brand;

    public PatentBrandDTO(String patent, String brand) {
        super(patent);
        this.brand = brand;
    }
}
