package com.example.ejclavecompuesta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "person")
@IdClass(PersonKey.class)
public class Person {
  @Id
  private Integer dni;
  @Id
  private Integer numTramite;
}
