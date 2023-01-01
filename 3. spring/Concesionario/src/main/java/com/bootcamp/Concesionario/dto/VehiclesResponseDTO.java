package com.bootcamp.Concesionario.dto;

import com.bootcamp.Concesionario.models.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class VehiclesResponseDTO {

    String brand;
    String model;
    String manufacturinDate;
    String numberofKilometers;
    String doors;
    int price;
    String currency;
    String countOfOwners;
}
