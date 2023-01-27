package com.example.segurosvehiculos.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Year;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VehiculoRequestDTO {
  String patente;
  String marca;
  String modelo;
  Year anio;
  @JsonProperty("cantidad_ruedas")
  Integer cantRuedas;
}
