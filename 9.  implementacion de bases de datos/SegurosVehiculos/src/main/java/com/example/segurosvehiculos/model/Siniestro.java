package com.example.segurosvehiculos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "siniestro")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private LocalDate fecha;
  @Column(name = "perdida_total")
  private Integer perdidaTotal;
  @ManyToOne
  @JoinColumn(name = "vehiculo_id", nullable = false)
  private Vehiculo vehiculo;

}
