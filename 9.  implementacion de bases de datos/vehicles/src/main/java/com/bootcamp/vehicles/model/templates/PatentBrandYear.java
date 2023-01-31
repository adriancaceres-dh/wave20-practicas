package com.bootcamp.vehicles.model.templates;

public class PatentBrandYear extends Patent {

    private final String brand;
    private final Integer productionYear;

    public PatentBrandYear(String patent, String brand, Integer productionYear) {
        super(patent);
        this.brand = brand;
        this.productionYear = productionYear;
    }
}
