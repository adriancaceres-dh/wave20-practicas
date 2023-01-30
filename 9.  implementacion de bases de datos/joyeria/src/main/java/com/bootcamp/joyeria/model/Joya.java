package com.bootcamp.joyeria.model;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nro_identificatorio;

    private String nombre;

    private String material;
    private Float peso;

    private String particularidad;
    private Boolean posee_piedra;

    private Boolean ventaONo;
}
