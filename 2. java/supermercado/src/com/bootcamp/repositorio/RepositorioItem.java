package com.bootcamp.repositorio;

import com.bootcamp.clases.Factura;
import com.bootcamp.clases.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioItem implements ICRUD<Item> {
    private final List<Item> items;

    public RepositorioItem() {
        items = new ArrayList<>();
    }

    @Override
    public boolean guardarElemento(Item elemento) {
        if(obtenerElemento(elemento.getCodigo()).isPresent())
            return false;
        return items.add(elemento);
    }

    @Override
    public boolean eliminarElemento(String id) {
        if(obtenerElemento(id).isEmpty())
            return false;
        return items.removeIf(f -> id.equals(f.getCodigo()));
    }

    @Override
    public Optional<Item> obtenerElemento(String id) {
        return items.stream().filter(c -> id.equals(c.getCodigo())).findFirst();
    }

    @Override
    public List<Item> obtenerElementos() {
        return items;
    }
}
