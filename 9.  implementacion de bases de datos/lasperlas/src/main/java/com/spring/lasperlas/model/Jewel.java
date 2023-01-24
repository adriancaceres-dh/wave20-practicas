package com.spring.lasperlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean haveRock;
    private Boolean forSale;
}

//nro_identificatorio, nombre, material (oro, plata, etc), peso (en gramos), particularidad, posee_piedra, ventaONo.
