package com.example.segurosvehiculos.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroRequestDTO {
  private LocalDate fecha;
  @JsonProperty("perdida_total")
  private Integer perdidaTotal;
  @JsonProperty("vehiculo_id")
  private Integer vehiculoId;
}
