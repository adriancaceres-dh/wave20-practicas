package com.example.ejercicioopcional.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "prenda")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column()
    private String name;
    @Column()
    private String type;
    @Column()
    private String brand;
    @Column()
    private String color;
    @Column()
    private Integer size;
    @Column()
    private Integer quantity;
    @Column()
    private Double price;
}
