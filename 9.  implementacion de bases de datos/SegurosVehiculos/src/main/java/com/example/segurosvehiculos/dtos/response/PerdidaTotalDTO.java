package com.example.segurosvehiculos.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class PerdidaTotalDTO {
  @JsonProperty("perdida_total")
  Integer perdidaTotal;
  List<PatenteMarcaModeloResponseDTO> vehiculos;
}
