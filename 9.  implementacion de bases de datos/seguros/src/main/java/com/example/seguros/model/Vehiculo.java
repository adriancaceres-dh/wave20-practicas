package com.example.seguros.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehiculo;
    private long patente;
    private String marca;
    private String model;
    private LocalDate fechaFabricacion;
    private int cantRuedas;
    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestroList;
}
