package com.mercadolibre;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String[] dnis = {"12345678", "87654321", "11111111", "22222222", "33333333"};
    Cliente cliente1 = new Cliente("Juan", "Perez", dnis[0]);
    Cliente cliente2 = new Cliente("Maria", "Gomez", dnis[1]);
    Cliente cliente3 = new Cliente("Pedro", "Gomez", dnis[2]);
    Map<String, Cliente> listaClientes = new HashMap<>(){{
      put(cliente1.getDni(), cliente1);
      put(cliente2.getDni(), cliente2);
      put(cliente3.getDni(), cliente3);
    }};

    RepositorioClientes repositorioClientes = new RepositorioClientes(listaClientes);
    repositorioClientes.getClientes().values().stream().forEach(cliente -> System.out.println(cliente));
    repositorioClientes.eliminarCliente(dnis[1]);
    System.out.println("Lista de clientes sin el cliente 1");
    repositorioClientes.getClientes().values().stream().forEach(cliente -> System.out.println(cliente));

    System.out.println("Ingresar dni a buscar: ");
    Scanner scanner = new Scanner(System.in);
    String dni = scanner.nextLine();
    if (repositorioClientes.buscarCliente(dni) == null) {
      System.out.println("No se encontro el cliente");
    } else {
      System.out.println(repositorioClientes.buscarCliente(dni));
    }

  }
}