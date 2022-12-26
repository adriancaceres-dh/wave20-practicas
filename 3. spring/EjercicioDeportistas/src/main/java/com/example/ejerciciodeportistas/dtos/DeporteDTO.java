package com.example.ejerciciodeportistas.dtos;

import java.io.Serializable;

public class DeporteDTO implements Serializable {
  private String nombre;
  private int nivel;

  public DeporteDTO(String nombre, int nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }

  public DeporteDTO() {
  }

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
