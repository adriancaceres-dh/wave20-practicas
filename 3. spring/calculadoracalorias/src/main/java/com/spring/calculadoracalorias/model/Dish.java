package com.spring.calculadoracalorias.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Dish {
    private String name;
    private double weight;
    private List<String> ingredients;

}
