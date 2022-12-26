package com.wave20.ejercicio_covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sintoma {

   private int codigo;
   private String nombre;
   private String nivel_gravedad;
}
