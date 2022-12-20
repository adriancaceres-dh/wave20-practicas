package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Cliente cliente1=new Cliente("10456","pepe","perez");
        Cliente cliente2=new Cliente("10678","carlos","torres");
        Cliente cliente3=new Cliente("12958","maria","carvajal");

        List<Cliente> clientes=new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.stream().forEach(System.out::println);
        clientes.remove(0);
        System.out.println("");
        clientes.stream().forEach(System.out::println);

        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese el dni:");
        String dni=teclado.next();
        List<Cliente> filterClientes=clientes.stream().filter(x->x.getDni().equals(dni)).collect(Collectors.toList());
        if (filterClientes.size()>0) System.out.println(filterClientes.get(0));
        else System.out.println("No se encuentra el cliente");

    }
}
