package com.bootcamp.showroom_elastic.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellDTO {
    private String id;
    private LocalDate date;
    private BigDecimal total;
    private String paymentMethod;
    private List<ClothingDTO> clothes;
}
