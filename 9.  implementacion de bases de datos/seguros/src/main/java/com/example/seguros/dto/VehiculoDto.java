package com.example.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class VehiculoDto {
    private int idVehiculo;
    private long patente;
    private String marca;
    private String model;
    private LocalDate fechaFabricacion;
    private int cantRuedas;
    private List<SiniestroSimpleDto> siniestroSimpleDtoList;
}
