package com.bootcamp.covid.model;

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private List<Sintoma> sintomas;

    public Persona() {
        sintomas = new ArrayList<>();
    }
    public boolean agregarSintoma(Sintoma sintoma) {
        sintomas.add(sintoma);
        return true;
    }
    public int edad() {
        return (int) ChronoUnit.YEARS.between(fechaNacimiento,LocalDate.now());
    }
}
