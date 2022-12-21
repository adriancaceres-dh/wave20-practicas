package com.bootcamp;

import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Factura;
import com.bootcamp.clases.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Crear listas de clientes y facturas
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente("ASH1654", "Alejandro", "Gómez"),
                new Cliente("JGD945", "Paulina", "Jiménez"),
                new Cliente("KVB850", "Ana", "Sánchez")
        ));
        List<Factura> facturas = new ArrayList<>();

        // PARTE 1
        System.out.println();
        System.out.println("PARTE 1");

        // Mostrar todos los clientes
        System.out.println();
        System.out.println("CLIENTES REGISTRADOS:");
        clientes.forEach(System.out::println);

        // Eliminar un cliente
        clientes.remove(1);

        // Mostrar los clientes restantes
        System.out.println();
        System.out.println("UN CLIENTE ELIMINADO\n");
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

        System.out.println();
        System.out.println(clienteBuscado.map(cliente -> "CLIENTE ECONTRADO: " + cliente)
                .orElse("EL CLIENTE NO SE ENCUENTRA REGISTRADO"));

        // PARTE 2
        System.out.println();
        System.out.println("PARTE 2");

        // Crear lista de items y nuevo cliente
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("MAN", "manzana", 3, 10),
                new Item("PLA", "platano", 2, 15),
                new Item("NAR", "naranja", 1, 12)
        ));
        Cliente cliente = new Cliente("KGS934", "Alberto", "Sánchez");

        // Verificar existencia de cliente
        if(!clientes.stream().map(Cliente::getDni).collect(Collectors.toSet()).contains(cliente.getDni()))
            clientes.add(cliente);

        // Crear factura
        facturas.add(new Factura(cliente, items));

        // Mostrar los clientes
        System.out.println();
        System.out.println("CLIENTES:");
        clientes.forEach(System.out::println);

        // Mostrar las facturas
        System.out.println();
        System.out.println("FACTURAS:");
        facturas.forEach(System.out::println);
    }
}
