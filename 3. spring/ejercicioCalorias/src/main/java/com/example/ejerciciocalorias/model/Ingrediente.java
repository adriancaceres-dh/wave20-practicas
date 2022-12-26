package com.example.ejerciciocalorias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingrediente {
  private String nombre;
  private int peso;
  private int calorias;
}
