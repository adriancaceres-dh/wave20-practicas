package com.bootcamp.repositorio;

import com.bootcamp.clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioFactura implements ICRUD<Factura> {
    private final List<Factura> facturas;

    public RepositorioFactura() {
        facturas = new ArrayList<>();
    }

    @Override
    public boolean guardarElemento(Factura elemento) {
        if(obtenerElemento(elemento.getCodigo()).isPresent())
            return false;
        return facturas.add(elemento);
    }

    @Override
    public boolean eliminarElemento(String id) {
        if(obtenerElemento(id).isEmpty())
            return false;
        return facturas.removeIf(f -> id.equals(f.getCodigo()));
    }

    @Override
    public Optional<Factura> obtenerElemento(String id) {
        return facturas.stream().filter(c -> id.equals(c.getCodigo())).findFirst();
    }

    @Override
    public List<Factura> obtenerElementos() {
        return facturas;
    }
}
