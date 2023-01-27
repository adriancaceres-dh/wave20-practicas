package com.example.segurosvehiculos.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Year;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDTO {

  private Integer id;
  String patente;
  String marca;
  String modelo;
  Year anio;
  @JsonProperty("cantidad_ruedas")
  Integer cantRuedas;
}
