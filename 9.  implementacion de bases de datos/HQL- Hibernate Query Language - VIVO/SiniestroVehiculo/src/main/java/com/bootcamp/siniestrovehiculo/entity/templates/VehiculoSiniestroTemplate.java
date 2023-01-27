package com.bootcamp.siniestrovehiculo.entity.templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroTemplate {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;

}
