package com.bootcamp.ConsultasHQL.model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatenteMarcaModeloDeVehiculoTemplate {
    private String patente;
    private String marca;
    private String modelo;
}
