package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JewelOperationResponseDto {
    @JsonProperty("operacion")
    private Operations operation;
    @JsonProperty("nro_identificatorio")
    private Long id;
}
