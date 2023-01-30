package com.implementacion_bd.Joyeria.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaResponseDTO {
    public String nombre;
    public String material;
    public Double peso;
    public String particularidad;
    public Boolean posee_piedra;
}
