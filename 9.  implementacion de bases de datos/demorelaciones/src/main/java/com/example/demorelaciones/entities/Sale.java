package com.example.demorelaciones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "sales")
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "sale_id")
  private List<SaleDetails> saleDetails;
}
