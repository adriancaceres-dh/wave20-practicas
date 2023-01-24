package com.bootcamp.joyeria.dto.response;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JoyaResponseDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
}
