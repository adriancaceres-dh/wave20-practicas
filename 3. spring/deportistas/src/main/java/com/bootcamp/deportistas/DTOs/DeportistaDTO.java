package com.bootcamp.deportistas.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeportistaDTO {
    private  String nombre;
    private String apellido;
    private String deporte;

}
