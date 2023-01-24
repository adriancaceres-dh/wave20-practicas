package com.bootcamp.Joyeria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoyaResponseDTO {

    String nombre, material, particularidad;
    Double peso;
    Boolean posee_piedra, ventaONo;

}
