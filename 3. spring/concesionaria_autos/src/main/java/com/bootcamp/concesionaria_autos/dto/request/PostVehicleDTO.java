package com.bootcamp.concesionaria_autos.dto.request;

import com.bootcamp.concesionaria_autos.dto.common.VehicleServiceDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostVehicleDTO {

    private int id;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<VehicleServiceDTO> services;
    private String countOfOwners;
}
