package com.example.CrudConJpaEjPractico.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "joya")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "nombre")
    String nombre;

    @Column(name = "material")
    String material;

    @Column(name = "peso")
    int peso;

    @Column(name = "particularidad")
    String particularidad;

    @Column(name = "posee_piedra")
    boolean posee_piedra;

    @Column(name = "ventaONo")
    boolean ventaONo;

}
