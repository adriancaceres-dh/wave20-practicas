package com.joyeria.joyeria.entity;

import com.joyeria.joyeria.enums.MaterialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Joya")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50)
    private String name;
    @Column(name = "material")
    private String material;
    @Column(name = "peso")
    private Double weight;
    @Column(name = "particularidad", length = 50)
    private String particularity;
    @Column(name = "posee_piedra")
    private Boolean hasStone;
    @Column(name = "esta_a_venta", length = 20)
    private Boolean isOnSale;
}
