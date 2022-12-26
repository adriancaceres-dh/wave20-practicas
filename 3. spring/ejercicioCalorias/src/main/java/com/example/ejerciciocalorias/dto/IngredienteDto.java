package com.example.ejerciciocalorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredienteDto {
  private String nombre;
  private int peso;
  private int calorias;
}
