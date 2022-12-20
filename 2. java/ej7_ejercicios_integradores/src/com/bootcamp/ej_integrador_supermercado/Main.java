package com.bootcamp.ej_integrador_supermercado;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Supermercado supermercado = new Supermercado();

        supermercado.crearCliente(new Cliente("123","nombre1","apellido1"));
        supermercado.crearCliente(new Cliente("234","nombre2","apellido2"));
        supermercado.crearCliente(new Cliente("345","nombre3","apellido3"));

        System.out.println("Ingrese dni del cliente a buscar: ");
        Scanner sc= new Scanner(System.in);
        String dni= sc.nextLine();

        supermercado.consultaClientes(dni);

        sc.close();


    }
}
