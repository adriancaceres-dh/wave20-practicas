package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoyaRequestDTO {
  private String nombre;
  private String material;
  private double peso;
  private String particularidad;
  @JsonProperty("tiene_piedra")
  private boolean tienePiedra;
}
