package com.bootcamp;

import com.bootcamp.clases.Cliente;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente("ASH1654", "Alejandro", "Gómez"),
                new Cliente("JGD945", "Paulina", "Jiménez"),
                new Cliente("KVB850", "Ana", "Sánchez")
        ));

        // Mostrar todos los clientes
        System.out.println();
        System.out.println("CLIENTES REGISTRADOS:");
        clientes.forEach(System.out::println);

        // Eliminar un cliente
        clientes.remove(1);

        // Mostrar los clientes restantes
        System.out.println();
        System.out.println("UN CLIENTE ELIMINADO");
        System.out.println("CLIENTES RESTANTES:");
        clientes.forEach(System.out::println);

        // Solicitar cliente a buscar
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("POR FAVOR, INGRESE EL DNI DEL CLIENTE A BUSCAR:");

        String dni = scanner.nextLine();
        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter(c -> dni.equalsIgnoreCase(c.getDni()))
                .findFirst();

        System.out.println(clienteBuscado.map(cliente -> "CLIENTE ECONTRADO: " + cliente)
                .orElse("EL CLIENTE NO SE ENCUENTRA REGISTRADO"));
    }
}
