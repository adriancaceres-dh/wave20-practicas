package com.bootcamp.joyeria.joyeria.models;

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
@Table(name = "jewel")
public class Jewel {

    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdNum;

    @Column(name = "nombre")
    private String name;
    private String material;
    @Column(name="peso")
    private Double weight;

    @Column(name = "particularidad")
    private String particularity;
    @Column(name = "posee_piedra")
    private Boolean hasStone;

    @Column (name = "ventaONo")
    private Boolean saleOrNo;

    @Override
    public String toString() {
        return "Jewel{" +
                "IdNum=" + IdNum +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                ", particularity='" + particularity + '\'' +
                ", hasStone=" + hasStone +
                ", saleOrNo=" + saleOrNo +
                '}';
    }
}
