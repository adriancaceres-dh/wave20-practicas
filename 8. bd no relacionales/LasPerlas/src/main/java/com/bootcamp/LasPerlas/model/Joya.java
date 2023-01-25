package com.bootcamp.LasPerlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_piedra;

    private Boolean ventaONo;

}
