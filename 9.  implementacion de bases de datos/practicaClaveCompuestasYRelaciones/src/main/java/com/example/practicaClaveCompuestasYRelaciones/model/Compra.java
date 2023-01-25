package com.example.practicaClaveCompuestasYRelaciones.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "compras")
@IdClass(value=CompraKey.class)
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date fecha;
    @Id
    private Integer clienteId;
    @Column(length = 40)
    private String cajero;
    private Integer numCaja;
}
