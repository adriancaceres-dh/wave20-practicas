package com.example.seguros.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class MensajeDto {
    private String mensaje;
    private String action;
}
