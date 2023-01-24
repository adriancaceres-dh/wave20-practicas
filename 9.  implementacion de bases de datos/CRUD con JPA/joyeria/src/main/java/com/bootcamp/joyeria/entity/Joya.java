package com.bootcamp.joyeria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

}
