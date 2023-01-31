package com.bootcamp.vehicles.model.templates;

public class PatentBrandModelEconomicLoss extends Patent {

    private final String brand;
    private final String model;
    private final Double economicLoss;

    public PatentBrandModelEconomicLoss(String patent, String brand, String model, Double economicLoss) {
        super(patent);
        this.brand = brand;
        this.model = model;
        this.economicLoss = economicLoss;
    }
}
