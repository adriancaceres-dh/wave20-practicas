package com.ORM.jpa.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15)
    private String nombre;

    @Column(length = 15)
    private String apellido;

    @Column(length = 50)
    private String mail;

    @Column(scale = 2)
    private Integer edad;

    @Column(name = "documento_identidad", length = 8)
    private String dni;
}
