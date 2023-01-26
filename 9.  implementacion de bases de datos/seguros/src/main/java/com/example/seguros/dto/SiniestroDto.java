package com.example.seguros.dto;

import lombok.*;

import java.time.LocalDate;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SiniestroDto {
    private int IdSiniestro;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    private VehiculoSimpleDto vehiculo;
}
