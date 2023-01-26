package com.bootcamp.showroom_elastic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClothingDTO {
    private String id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Short amount;
    private BigDecimal sellPrice;
}
