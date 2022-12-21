package com.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class Supermercado {
    Set<Cliente> repoClientes;
    Set<Factura> repoFacturas;

    public Supermercado() {
        this.repoClientes = new HashSet<>();
        this.repoFacturas = new HashSet<>();
    }

    public void agregarCliente (Cliente c) {
        repoClientes.add(c);
    }

    public void removerCliente (Long dni) {
        Cliente borrado = null;
        for (Cliente c : repoClientes) {
            if (c.getDni().equals(dni)) borrado = c;
        }
        repoClientes.remove(borrado);
    }

    public boolean buscarCliente (Long dni) {
        boolean encontrado = false;
        for (Cliente c : repoClientes) {
            if (c.getDni().equals(dni)) {
                encontrado = true;
                System.out.println("Cliente encontrado, sus datos son:");
                System.out.println(c);
            }
        }
        return encontrado;
    }

    public void agregarFactura (Factura f) {
        if (!repoClientes.contains(f.getCliente())) agregarCliente(f.getCliente());
        repoFacturas.add(f);
    }

    public void mostrarClientes () {
        repoClientes.stream().forEach(c -> System.out.println(c));
    }
}
