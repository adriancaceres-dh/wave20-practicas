package com.example.Empresa.Seguros.Practica.HQL.Vivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @ManyToOne
    private Vehiculo vehiculoDenunciado;

}
