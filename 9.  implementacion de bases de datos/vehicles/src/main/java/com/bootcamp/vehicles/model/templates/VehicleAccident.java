package com.bootcamp.vehicles.model.templates;

import com.bootcamp.vehicles.model.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleAccident {

    private Vehicle vehicle;
    private Double economicLoss;
}
