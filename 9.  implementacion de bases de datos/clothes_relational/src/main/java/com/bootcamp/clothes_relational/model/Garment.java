package com.bootcamp.clothes_relational.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "clothes")
public class Garment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long code;
    @Column(nullable = false)
    private String name;
    private String type;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String size;
    private Integer quantity;
    @Column(nullable = false)
    private Double price;
}
