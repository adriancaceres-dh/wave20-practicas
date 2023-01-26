package com.bootcamp.seguros.dto;

import com.bootcamp.seguros.model.Sinister;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate anoDeFabricacion;
    private int cantidadDeRuedas;
    private List<SinisterDTO> sinisterList;

}
