package com.bootcamp.joyerialasperlas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nro_identificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_piedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;

}
