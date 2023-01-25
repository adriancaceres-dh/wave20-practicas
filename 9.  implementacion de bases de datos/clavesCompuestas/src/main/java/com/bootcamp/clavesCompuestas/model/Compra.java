package com.bootcamp.clavesCompuestas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id
    private LocalDate fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    private String producto;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


}
