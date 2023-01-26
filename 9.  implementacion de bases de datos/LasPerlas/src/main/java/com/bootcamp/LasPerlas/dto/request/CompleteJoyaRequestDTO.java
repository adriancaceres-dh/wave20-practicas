package com.bootcamp.LasPerlas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompleteJoyaRequestDTO {
    final Long id;
    final String nombre;
    final String material;
    final Double peso;
    final String particularidad;
    @JsonProperty("posee_piedra")
    final boolean poseePiedra;
    final boolean ventaONo;
}
