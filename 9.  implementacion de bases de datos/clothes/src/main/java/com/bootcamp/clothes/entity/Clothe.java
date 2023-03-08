package com.bootcamp.clothes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Clothe {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;

    @Id
    private Integer code;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String brand;

    @Column
    private String color;

    @Column
    private Integer size;

    @Column
    private Double salesPrice;

    @OneToMany(mappedBy = "clothe")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ClotheSale> clotheSales;

}
