package com.example.ejerciciocalorias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Plato {
  private String nombre;
  private int peso;
  //los pesos de los igredientes son por cada 100 g del plato
  private List<Ingrediente> ingredientes;
}
