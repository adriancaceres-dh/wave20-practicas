package com.example.ejerciciodeportistas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Deporte {

  private int nivel;
  @Id
  private String nombre;

  public Deporte(String nombre, int nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }

  public Deporte() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

}
