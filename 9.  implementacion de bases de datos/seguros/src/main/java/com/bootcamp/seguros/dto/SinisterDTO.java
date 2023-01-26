package com.bootcamp.seguros.dto;

import com.bootcamp.seguros.model.Vehicle;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SinisterDTO {
    private Long  id;
    private LocalDate fechaDelSiniestro;
    private double perdidaEconomica;
}
