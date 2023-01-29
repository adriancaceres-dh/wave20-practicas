package com.example.JoyeriaLasPerlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
