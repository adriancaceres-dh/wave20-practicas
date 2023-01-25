package com.joyeria.joyeria.dto;

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
public class JewelResponseDto {
    private Integer id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean hasStone;
    private Boolean isOnSale;
}
