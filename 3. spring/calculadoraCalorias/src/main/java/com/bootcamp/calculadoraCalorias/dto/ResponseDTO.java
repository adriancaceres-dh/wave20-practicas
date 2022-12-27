package com.bootcamp.calculadoraCalorias.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDTO {
    List<DishDTO> Dishes;
}
