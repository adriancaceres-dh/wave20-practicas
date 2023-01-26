package com.bootcamp.vehiculos.model.template;

import com.bootcamp.vehiculos.model.Vehiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VehiculoPerdida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @OneToOne
    private Vehiculo vehiculo;
    private BigDecimal perdida;

    public VehiculoPerdida(Vehiculo vehiculo, BigDecimal perdida) {
        this.vehiculo = vehiculo;
        this.perdida = perdida;
    }
}
