package com.bootcamp.siniestrovehiculo.entity.templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroExtendidoTemplate {

    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaTotal;

}
