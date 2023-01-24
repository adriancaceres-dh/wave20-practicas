package com.example.jpa_ej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // toString, hasCode, equals, geter, setter, value
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "documento", length = 10)
    private String dni;
    @Column(name = "edad", scale = 2)
    private Integer edad;
    @Column(name = "direccion", length = 50)
    private String direccion;
    @Column(length = 20)
    private String telefono;
}
