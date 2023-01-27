package com.example.segurosvehiculos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "vehiculo")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  String patente;
  String marca;
  String modelo;
  Year anio;
  @Column(name = "cantidad_ruedas")
  Integer cantRuedas;
  @OneToMany(mappedBy = "vehiculo")
  List<Siniestro> siniestros;

}
