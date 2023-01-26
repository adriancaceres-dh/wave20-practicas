package com.bootcamp.ConsultasHQL.dto.response;

import com.bootcamp.ConsultasHQL.model.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class SiniestroResponseDTO {
    private LocalDate fechaDelSiniestro;
    private Double perdidaEconomica;
    private Vehiculo vehiculo;
}
