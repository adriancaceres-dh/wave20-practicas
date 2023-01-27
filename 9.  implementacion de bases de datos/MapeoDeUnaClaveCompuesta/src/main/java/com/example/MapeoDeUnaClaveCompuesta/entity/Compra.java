package com.example.MapeoDeUnaClaveCompuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="compra")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientid;
    @Id
    private LocalDate fecha;

    private String articulo;



}
