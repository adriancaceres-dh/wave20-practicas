package com.HQLAutos.HQLAutos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String patente;
    String marca;
    String modelo;
    LocalDate fechaFabricacion;
    Integer cantidadRuedas;

}
