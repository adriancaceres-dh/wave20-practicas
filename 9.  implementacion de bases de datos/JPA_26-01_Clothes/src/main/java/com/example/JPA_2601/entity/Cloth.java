package com.example.JPA_2601.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column
    private String nombre;
    @Column
    private String tipo;
    @Column
    private String marca;
    @Column
    private String color;
    @Column
    private Integer talle;
    @Column
    private Integer cantidad;
    @Column(name = "precio_venta")
    private Double precioVenta;


}
