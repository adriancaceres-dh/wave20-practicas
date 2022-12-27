package com.bootcamp.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    private LocalDate fecha;
    private int kilometraje;
    private String descripcion;
}
