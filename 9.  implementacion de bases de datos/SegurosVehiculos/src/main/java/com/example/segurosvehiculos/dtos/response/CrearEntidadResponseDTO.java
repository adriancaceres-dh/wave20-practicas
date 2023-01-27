package com.example.segurosvehiculos.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class CrearEntidadResponseDTO {
  private Integer id;
  private String message;
}
