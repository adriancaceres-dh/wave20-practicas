package com.bootcamp._concesionaria_de_autos.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Vehicle {

    private Long id;
    private String brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, countOfOwners;
    private Map<String,String> services;
}
