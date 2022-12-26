package com.bootcamp.CalculadoraCalorias.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Plato {

    private String nombre;
    private double peso;
    List<String> ingredientes;


}
