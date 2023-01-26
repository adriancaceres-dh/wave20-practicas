package com.example.seguros.dto;

import lombok.*;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class VehiculoSimpleDto {

    private int idVehiculo;
    private long patente;
    private String marca;
    private String model;
    private LocalDate fechaFabricacion;
    private int cantRuedas;

}
