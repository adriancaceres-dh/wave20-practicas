package com.example.lasperlas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jewels")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // hace referencia tambien al numero identificatorio, no tiene sentido otro campo

    private String name;

    private String material;

    private String particularity;

    private Double weight;

    @Column(name = "has_stones")
    private boolean hasStones;

    @Column(name = "can_be_sold")
    private boolean canBeSold;
}
