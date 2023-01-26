package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoyaResponseDTO {
  @JsonProperty("nro_id")
  private Integer id;
  private String nombre;
  private String material;
  private double peso;
  private String particularidad;
  @JsonProperty("tiene_piedra")
  private boolean tienePiedra;
  private boolean ventaONo;
}
