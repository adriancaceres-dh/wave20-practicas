package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "documento_identidad", length = 10)
  private String dni;
  @Column(scale = 2)
  private Integer edad;
  @Column(length = 50)
  private String direccion;
  @Column(length = 20)
  private String telefono;

}
