package com.bootcamp.las_perlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
