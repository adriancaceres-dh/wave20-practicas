package com.bootcamp.deportistas.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
     private String nombreDeporte;


}
