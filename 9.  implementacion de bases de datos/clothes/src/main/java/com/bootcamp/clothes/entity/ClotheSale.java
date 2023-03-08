package com.bootcamp.clothes.entity;

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
@Table(name = "clothe_sale")
public class ClotheSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clothe_id", referencedColumnName = "code")
    private Clothe clothe;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "number")
    private Sale sale;

    private Integer quantity;
}
