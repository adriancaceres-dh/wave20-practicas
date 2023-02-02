package com.bootcamp.deportistas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}
