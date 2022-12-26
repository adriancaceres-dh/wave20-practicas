package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto implements Serializable {
  private String name;
  private int height;
  private int mass;
  private String gender;
  private String homeworld;
  private String species;

}
