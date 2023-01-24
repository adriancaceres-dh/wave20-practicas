package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JewelRequestDto {
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
