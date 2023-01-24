package com.bootcamp.Joyeria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoyaRequestDTO {

    String nombre, material, particularidad;
    Double peso;
    Boolean posee_piedra;
}
