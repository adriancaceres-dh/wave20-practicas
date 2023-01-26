package com.bootcamp.vehiculos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaSiniestro;

    private BigDecimal perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculoDenunciado;
}
