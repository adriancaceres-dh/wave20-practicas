package com.bootcamp.clavescompuestas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    Integer clienteId;

    @Id
    LocalDate fechaCompra;

    Double total;
}
