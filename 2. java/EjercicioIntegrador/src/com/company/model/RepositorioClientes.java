package com.company.model;

import java.util.HashSet;
import java.util.Set;

public class RepositorioClientes {
    Set<Cliente> clientes;

    public RepositorioClientes() {
        this.clientes = clientes = new HashSet<>();
    }

    public boolean agregarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }
}
