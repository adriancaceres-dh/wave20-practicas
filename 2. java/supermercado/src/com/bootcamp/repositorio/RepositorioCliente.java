package com.bootcamp.repositorio;

import com.bootcamp.clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements ICRUD<Cliente> {
    private final List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public boolean guardarElemento(Cliente elemento) {
        if(obtenerElemento(elemento.getDni()).isPresent())
            return false;
        return clientes.add(elemento);
    }

    @Override
    public boolean eliminarElemento(String id) {
        if(obtenerElemento(id).isEmpty())
            return false;
        return clientes.removeIf(c -> id.equals(c.getDni()));
    }

    @Override
    public Optional<Cliente> obtenerElemento(String id) {
        return clientes.stream().filter(c -> id.equals(c.getDni())).findFirst();
    }

    @Override
    public List<Cliente> obtenerElementos() {
        return clientes;
    }
}
