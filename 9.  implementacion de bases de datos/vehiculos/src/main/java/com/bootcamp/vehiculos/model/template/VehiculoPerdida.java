package com.bootcamp.vehiculos.model.template;

import com.bootcamp.vehiculos.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class VehiculoPerdida {
    private Vehiculo vehiculo;
    private BigDecimal perdida;
}
