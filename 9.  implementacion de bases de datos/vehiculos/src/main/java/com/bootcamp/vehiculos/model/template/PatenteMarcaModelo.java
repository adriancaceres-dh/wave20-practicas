package com.bootcamp.vehiculos.model.template;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatenteMarcaModelo extends PatenteYMarca {
    private String modelo;

    public PatenteMarcaModelo(String patente, String marca, String modelo) {
        super(patente, marca);
        this.modelo = modelo;
    }
}
