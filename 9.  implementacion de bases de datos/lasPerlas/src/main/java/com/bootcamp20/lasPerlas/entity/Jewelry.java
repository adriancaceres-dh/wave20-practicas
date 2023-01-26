package com.bootcamp20.lasPerlas.entity;

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
@Table(name = "jewelry")
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nro_identifying;

    @Column(name = "jewelry_name", length = 30)
    private String name;

    @Column(name = "jewelry_material", length = 20)
    private String material;

    @Column(name = "jewelry_weight", precision = 2)
    private Double weight;

    @Column(name = "jewelry_specificity", length = 50)
    private String specificity;

    @Column(name = "jewelry_owns_stone")
    private boolean owns_stone;
    @Column(name = "jewelry_saleONo")
    private boolean saleONo;

}
