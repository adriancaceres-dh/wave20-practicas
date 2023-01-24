package com.bootcamp.joyeria.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MensajeDto {
    private String mensaje;
    private Integer estado;
}
