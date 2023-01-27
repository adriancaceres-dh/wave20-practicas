package com.example.segurosvehiculos.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiniestroResponseDTO {
  private Integer id;
  private LocalDate fecha;
  @JsonProperty("perdida_total")
  private Integer perdidaTotal;
  @JsonProperty("vehiculo_id")
  private Integer vehiculoId;
}
