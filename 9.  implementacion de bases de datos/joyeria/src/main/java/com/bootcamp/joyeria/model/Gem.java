package com.bootcamp.joyeria.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Joya")
public class Gem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;

}
