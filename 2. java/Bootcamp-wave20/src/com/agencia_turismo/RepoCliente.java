package com.agencia_turismo;

import java.util.*;

public class RepoCliente {

    private Map<Long, Cliente> clientes = new HashMap<>();


    public void agregarCliente(Long dni, String nombre, String apellido) {
        Cliente c = new Cliente(dni, nombre, apellido);
        clientes.put(dni, c);
    }

    public String eliminarCliente(Long dni) {
        Cliente c = clientes.get(dni);
        if (c == null) {
            return "No se encontró Cliente registrado con ese número de dni";
        } else {
            clientes.remove(dni);
            return "Cliente eliminado correctamente";
        }

    }

    public Optional<Cliente> encontrarCliente(Long dni) {
        Collection<Cliente> listaClientes = clientes.values();
        return listaClientes.stream().filter(c -> c.getDni().equals(dni)).findAny();

    }

    public void modificarCliente() {

    }

}
