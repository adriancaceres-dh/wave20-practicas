package com.example.ejercicio_concesionaria_de_autos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auto {

    private long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int CountOfOwners;

}
