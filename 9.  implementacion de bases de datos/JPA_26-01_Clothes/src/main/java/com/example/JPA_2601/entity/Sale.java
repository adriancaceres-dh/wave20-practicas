package com.example.JPA_2601.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    @Column
    private LocalDate fecha;
    @Column
    private Double total;
    @Column
    private String medioDePago;
    @OneToMany()
    private List<Cloth> clothList;
}
