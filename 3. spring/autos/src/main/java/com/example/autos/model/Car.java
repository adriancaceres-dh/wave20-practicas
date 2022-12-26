package com.example.autos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private double price;
    private int doors;
    private String currency;
    private List<CarServiceModel> services;
    private int countOfOwners;
}
