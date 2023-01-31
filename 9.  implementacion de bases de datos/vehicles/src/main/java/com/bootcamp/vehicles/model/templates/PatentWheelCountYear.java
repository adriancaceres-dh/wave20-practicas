package com.bootcamp.vehicles.model.templates;

public class PatentWheelCountYear extends Patent {

    private final Integer wheelCount;
    private final Integer productionYear;

    public PatentWheelCountYear(String patent, Integer wheelCount, Integer productionYear) {
        super(patent);
        this.wheelCount = wheelCount;
        this.productionYear = productionYear;
    }
}
