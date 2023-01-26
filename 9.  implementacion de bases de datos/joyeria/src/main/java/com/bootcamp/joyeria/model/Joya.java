package com.bootcamp.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private  Long nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;
    @Column(name = "ventaONo")
    private Boolean ventaONo;
}
