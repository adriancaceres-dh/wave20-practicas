package com.bootcamp;

import com.bootcamp.modelos.Cliente;
import com.bootcamp.modelos.DirectorioClientes;
import com.bootcamp.modelos.Factura;
import com.bootcamp.modelos.Item;

import java.util.ArrayList;
import java.util.List;

public class SuperMercado {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("21333","Camilo","Arango"));
        clientes.add(new Cliente("3123","Andrés","Castro"));
        clientes.add(new Cliente("5555","Luke","Skywalker"));
        //clientes.forEach(System.out::println);
        //.forEach(System.out::print)
        //System.out.println("----------------------------------");
        Cliente.removerCliente(clientes, "3123");
        //clientes.forEach(System.out::println);

        //Cliente clienteEncontrado = Cliente.mostrarCliente("5555",clientes);
        //System.out.println("----------------------------------");
        //System.out.println("clienteEncontrado = " + clienteEncontrado);
        //Cliente.agregarCliente(clientes, factura1.getCliente());
        //System.out.println("----------------------------------");
        //clientes.forEach(System.out::println);

        //Usando el directorio de clientes con CRUD

        DirectorioClientes directorioClientes = new DirectorioClientes();

        directorioClientes.crear(new Cliente("21333","Camilo","Arango"));
        directorioClientes.crear(new Cliente("3123","Andrés","Castro"));
        directorioClientes.crear(new Cliente("5555","Luke","Skywalker"));
        directorioClientes.crear(new Cliente("22433","Alejandra","Gil"));
        directorioClientes.getDirectorio().forEach(System.out::println);

        System.out.println(directorioClientes.buscar(directorioClientes.getDirectorio(),"3123"));

        Factura factura1 = new Factura(directorioClientes.getDirectorio().get(3));


        factura1.addItem(new Item(55,"Leche",1,3500.42))
                .addItem(new Item(20,"Carne de res",6,6000.44))
                .addItem(new Item(12,"Cerveza",5,2500.23));

        factura1.calcularTotal();
        System.out.println(factura1.getCliente());
        //System.out.println("----------------------------------");
        //System.out.println("Su total a pagar es " + factura1.getTotalFactura());

    }


}
