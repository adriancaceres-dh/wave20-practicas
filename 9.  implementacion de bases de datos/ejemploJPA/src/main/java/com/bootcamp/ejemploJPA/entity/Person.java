package com.bootcamp.ejemploJPA.entity;

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
@Table(name = "persona")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documento_identidad", length = 10)
    private String dni;

    @Column(scale = 2)
    private Integer edad;

    @Column(length = 50)
    private String direccion;

    @Column(length = 20)
    private String telefono;
}
