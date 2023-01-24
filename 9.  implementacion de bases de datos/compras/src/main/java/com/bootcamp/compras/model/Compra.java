package com.bootcamp.compras.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Getter @Setter
@Entity(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private String articulo;
}
