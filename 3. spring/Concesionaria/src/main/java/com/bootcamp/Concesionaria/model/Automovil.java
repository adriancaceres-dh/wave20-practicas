package com.bootcamp.Concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Data
@Builder
public class Automovil {

    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private double price;
    private String currency;
    private List<Service> services;
    private String countOfOwner;
}
