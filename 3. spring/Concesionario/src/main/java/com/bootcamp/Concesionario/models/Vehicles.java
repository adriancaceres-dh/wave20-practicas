package com.bootcamp.Concesionario.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicles {

    String brand;
    String model;
    String manufacturinDate;
    String numberofKilometers;
    String doors;
    int price;
    String currency;

    List<Service> listaServicios;
    String countOfOwners;


}
