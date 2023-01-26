package com.bootcamp.LasPerlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long id ;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    private boolean ventaONo;



}
