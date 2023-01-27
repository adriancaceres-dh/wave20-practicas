package com.example.segurosvehiculos.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class MarcaModeloResponseDTO {
  private String marca;
  private String modelo;
  private Year anio;
}
