package com.bootcamp.concesionaria_autos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleService {

    private LocalDate date;
    private double kilometers;
    private String descriptions;
}
