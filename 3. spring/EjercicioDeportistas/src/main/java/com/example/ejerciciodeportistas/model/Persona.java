package com.example.ejerciciodeportistas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Persona {
  private String nombre;
  private String apellido;
  private Integer edad;
  @ManyToOne
  private Deporte deporte;
  @Id
  private String id;

  public Persona(String nombre, String apellido, Integer edad, Deporte deporte) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.deporte = deporte;
  }

  public Persona() {}

  public Deporte getDeporte() {
    return deporte;
  }

  public void setDeporte(Deporte deporte) {
    this.deporte = deporte;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
