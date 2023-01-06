package com.bootcamp.concesionaria_autos.dto.response;

import com.bootcamp.concesionaria_autos.dto.common.VehicleServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AfterGetVehicleDTO {

    private int id;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<VehicleServiceDTO> services;
    private int countOfOwners;
}
