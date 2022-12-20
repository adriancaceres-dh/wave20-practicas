package com.bootcamp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1,"Julian","Atehortua");
        Cliente cliente2 = new Cliente(2,"Carolina","Zuluaga");
        Cliente cliente3 = new Cliente(3,"Luis","Velasquez");

        List<Cliente> listaClientes = Arrays.asList(cliente1,cliente2,cliente3);

        listaClientes.stream().forEach(System.out::println);

        System.out.println("---------------Eliminar cliente---------------");
        int clienteEliminar=2;
        List<Cliente> listaClientesNuevo = listaClientes.stream().filter(id->id.getDni()!=clienteEliminar).collect(Collectors.toList());
        listaClientes=listaClientesNuevo;
        System.out.println("CLientes actualizado"+listaClientes);

        System.out.println("-------------Buscar cliente----------");
        Scanner sp = new Scanner(System.in);
        System.out.print("Ingrese el dni a buscar: ");
        int dniBuscar = Integer.parseInt(sp.nextLine());
        try {
            listaClientes.stream().filter(id->id.getDni()==dniBuscar).forEach(System.out::println);
        }catch (Exception e){
            System.out.println("El cliente no esta registrado");
        }finally {
            System.out.println("El cliente no esta registrado");
        }



    }
}
