package com.example.seguros.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdSiniestro;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    @ManyToOne
    private Vehiculo vehiculo;
}
