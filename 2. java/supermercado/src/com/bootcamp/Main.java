package com.bootcamp;

import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Factura;
import com.bootcamp.clases.Item;
import com.bootcamp.repositorio.RepositorioCliente;
import com.bootcamp.repositorio.RepositorioFactura;
import com.bootcamp.repositorio.RepositorioItem;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // USANDO REPOSITORIOS

        // Crear repositorios
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioFactura repoFactura = new RepositorioFactura();
        RepositorioItem repoItem = new RepositorioItem();

        // Crear clientes
        Cliente alex = new Cliente("ASH165", "Alejandro", "Gómez");
        Cliente pau = new Cliente("JGD945", "Paulina", "Jiménez");
        Cliente ana = new Cliente("KVB850", "Ana", "Sánchez");
        Cliente al = new Cliente("KGS934", "Alberto", "Sánchez");
        Cliente fati = new Cliente("FKA962", "Fatima", "Juárez");

        // Agregar clientes al repo
        repoCliente.guardarElemento(alex);
        repoCliente.guardarElemento(pau);
        repoCliente.guardarElemento(ana);
        repoCliente.guardarElemento(al);

        // Mostrar todos los clientes
        System.out.println();
        System.out.println("CLIENTES REGISTRADOS:");
        repoCliente.obtenerElementos().forEach(System.out::println);

        // Eliminar un cliente y mostrar los restantes
        repoCliente.eliminarElemento(al.getDni());
        System.out.println();
        System.out.println("UN CLIENTE ELIMINADO\n");
        System.out.println("CLIENTES RESTANTES:");
        repoCliente.obtenerElementos().forEach(System.out::println);

        // Solicitar cliente a buscar y mostrarlo si existe en el repositorio
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("POR FAVOR, INGRESE EL DNI DEL CLIENTE A BUSCAR:");
        Optional<Cliente> clienteBuscado = repoCliente.obtenerElemento(scanner.nextLine());
        System.out.println();
        System.out.println(clienteBuscado.map(cliente -> "CLIENTE ECONTRADO: " + cliente)
                .orElse("EL CLIENTE NO SE ENCUENTRA REGISTRADO"));

        // Crear lista de items
        Item manzana = new Item("MAN", "manzana", 3, 10);
        Item platano = new Item("PLA", "platano", 2, 15);
        Item naranja = new Item("NAR", "naranja", 1, 12);

        // Agregar items al repo
        repoItem.guardarElemento(manzana);
        repoItem.guardarElemento(platano);
        repoItem.guardarElemento(naranja);

        // Agregar nuevo cliente
        repoCliente.guardarElemento(fati);

        // Agregar cliente por segunda vez para verificar que no se duplique
        repoCliente.guardarElemento(fati);

        // Agregar factura al repo
        repoFactura.guardarElemento(new Factura("KGJSGDFG92375", fati, repoItem.obtenerElementos()));

        // Mostrar todos los clientes
        System.out.println();
        System.out.println("CLIENTES REGISTRADOS:");
        repoCliente.obtenerElementos().forEach(System.out::println);

        // Mostrar todas las facturas
        System.out.println();
        System.out.println("FACTURAS REGISTRADAS:");
        repoFactura.obtenerElementos().forEach(System.out::println);

        // SIN REPOSITORIOS

        /*
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
        facturas.add(new Factura("SDFJKAS62345", cliente, items));

        // Mostrar los clientes
        System.out.println();
        System.out.println("CLIENTES:");
        clientes.forEach(System.out::println);

        // Mostrar las facturas
        System.out.println();
        System.out.println("FACTURAS:");
        facturas.forEach(System.out::println);
         */
    }
}
