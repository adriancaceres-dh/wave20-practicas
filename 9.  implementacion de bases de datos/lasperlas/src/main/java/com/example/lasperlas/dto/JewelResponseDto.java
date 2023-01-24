package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id"})
public class JewelResponseDto {

    @JsonProperty("nro_identificatorio")
    private Long id;

    @JsonProperty("nombre")
    private String name;

    private String material;

    @JsonProperty("particularidad")
    private String particularity;

    @JsonProperty("peso")
    private Double weight;

    @JsonProperty("posee_piedra")
    private boolean hasStones;

    @JsonProperty("ventaONo")
    private boolean canBeSold;
}
