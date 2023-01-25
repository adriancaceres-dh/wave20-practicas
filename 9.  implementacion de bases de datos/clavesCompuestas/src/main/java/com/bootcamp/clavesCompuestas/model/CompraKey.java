package com.bootcamp.clavesCompuestas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CompraKey implements Serializable {
    private LocalDate fecha;
    private Long clientId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(fecha, compraKey.fecha) && Objects.equals(clientId, compraKey.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, clientId);
    }
}
