package com.bootcamp.claves_compuestas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;

    private double precioTotal;

    private int cantProductos;


}
