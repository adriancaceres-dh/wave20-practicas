package com.example.ejercicioopcional.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "venta")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @Column()
    private LocalDate date;
    @Column()
    private Double total;
    @Column()
    private String paymentMethod;
    @OneToMany()
    private List<Cloth> clothes;
}
