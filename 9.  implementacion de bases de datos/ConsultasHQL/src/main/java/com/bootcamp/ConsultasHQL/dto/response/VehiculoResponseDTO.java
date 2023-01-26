package com.bootcamp.ConsultasHQL.dto.response;

import com.bootcamp.ConsultasHQL.model.Siniestro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class VehiculoResponseDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Long anoDeFabricacion;
    private Integer cantidadDeRuedas;
    private List<Siniestro> siniestros;
}
