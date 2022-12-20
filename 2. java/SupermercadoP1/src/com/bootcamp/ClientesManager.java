package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientesManager {
    private List<Cliente> clientes;

    public ClientesManager() {
        clientes = new ArrayList<>();
    }

    public void addClient(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removeClient(String dni) {
        Optional<Cliente> clienteEncontrado = clientes.stream()
                .parallel()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findAny();
        if (clienteEncontrado.isPresent()) {
            clientes.remove(clienteEncontrado.get());
        } else {
            System.out.println("No se pudo borrar el cliente con DNI: " + dni);
        }

    }

    public void displayAll() {
        clientes.forEach(System.out::println);
    }

    public void displayClient(String dni) {
        Optional<Cliente> clienteEncontrado = clientes.stream()
                .parallel()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findAny();

        if (clienteEncontrado.isPresent()) {
            System.out.println(clienteEncontrado.get());
        } else {
            System.out.println("No se encontró el cliente con DNI: " + dni);
        }
    }
}
