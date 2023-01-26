package com.example.lasperlas.model;

import com.example.lasperlas.utilities.Material;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "joyas")
public class Joya {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  private String material;
  private double peso;
  private String particularidad;
  private boolean tienePiedra;
  private boolean ventaONo = true;

  public void vendida() {
    this.ventaONo = false;
  }
}
