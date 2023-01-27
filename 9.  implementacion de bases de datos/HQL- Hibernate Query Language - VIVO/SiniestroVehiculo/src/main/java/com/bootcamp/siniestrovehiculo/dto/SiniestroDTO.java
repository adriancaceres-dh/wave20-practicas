package com.bootcamp.siniestrovehiculo.dto;

import com.bootcamp.siniestrovehiculo.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {

    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;

    private Vehiculo vehiculo;
}
