package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    List<Cliente> clientes;

    public RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        return clientes.size();
    }

    public boolean existeCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(cliente.getDni())) {
                return true;
            }
        }
        return false;
    }
}
