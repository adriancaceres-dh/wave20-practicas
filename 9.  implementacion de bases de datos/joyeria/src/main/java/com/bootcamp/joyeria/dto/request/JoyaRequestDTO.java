package com.bootcamp.joyeria.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoyaRequestDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;

}
