package com.joyeria.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.joyeria.joyeria.enums.MaterialType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JewelRequestDto {
    private Integer id;
    @NotNull(message = "El nombre no puede estar vacío")
    @JsonProperty("nombre")
    private String name;
    @NotNull(message = "El material no puede estar vacío")
    @JsonProperty("material")
    private String material;
    @NotNull(message = "El peso no puede estar vacío")
    @JsonProperty("peso")
    private Double weight;
    @NotNull(message = "la particularidad no puede estar vacía")
    @JsonProperty("particularidad")
    private String particularity;
    @NotNull(message = "Debe aclarar si tiene piedra")
    @JsonProperty("posee_piedra")

    private Boolean hasStone;
    @NotNull(message = "Debe aclarar si está a la venta")
    @JsonProperty("ventaONo")
    private Boolean isOnSale;
}
