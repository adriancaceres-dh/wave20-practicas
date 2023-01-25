package com.example.demorelaciones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToMany(mappedBy = "cart")
  private Set<Item> items;
}
