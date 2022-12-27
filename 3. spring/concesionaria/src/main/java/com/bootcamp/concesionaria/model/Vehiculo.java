package com.bootcamp.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private LocalDate fecha;
    private int kilometraje;
    private int cantPuertas;
    private double precio;
    private String pais;
    private List<Servicio> servicios;
    private int cantDueños;
}
