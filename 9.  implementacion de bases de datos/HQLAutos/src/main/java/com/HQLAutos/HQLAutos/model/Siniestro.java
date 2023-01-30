package com.HQLAutos.HQLAutos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate fecha;
    Double perdida;
    @ManyToOne
    Vehiculo vehiculo;
}
