package com.bootcamp.joyeria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "joya")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Integer nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
