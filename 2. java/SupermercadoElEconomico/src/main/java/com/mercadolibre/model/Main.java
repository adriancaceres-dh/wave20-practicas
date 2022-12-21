package com.mercadolibre.model;

import com.mercadolibre.repositorios.RepositorioClientes;
import com.mercadolibre.repositorios.RepositorioFacturas;

import java.util.*;

public class Main {

  private void run() {
    boolean salir = false;
    do {
      printMenu();
      Scanner scanner = new Scanner(System.in);
      int opcion = Integer.parseInt(scanner.nextLine());
      switch (opcion) {
        case 1:
          agregarCliente();
          break;
        case 2:
          eliminarCliente();
          break;
        case 3:
          buscarFacturasPorCliente();
          break;
        case 4:
          agregarFactura();
          break;
        case 5:
          imprimirClientes();
          break;
        case 6:
          salir = true;
          break;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    } while (!salir);
  }

  private void printMenu() {
    System.out.println("1. Agregar cliente");
    System.out.println("2. Eliminar cliente");
    System.out.println("3. Buscar facturas por cliente");
    System.out.println("4. Agregar nueva factura");
    System.out.println("5. Imprimir todos los clientes");
    System.out.println("6. Salir");
  }

  private void agregarCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el nombre del cliente");
    String nombre = scanner.nextLine();
    System.out.println("Ingrese el dni del cliente");
    String dni = scanner.nextLine();

    Cliente cliente = new Cliente(nombre, dni);
    boolean agregado = RepositorioClientes.getInstance().agregarItem(cliente);
    if (agregado) {
      System.out.println("Cliente agregado con exito");
    } else {
      System.out.println("No se pudo agregar el cliente");
    }
  }

  private void eliminarCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el dni del cliente a eliminar");
    String dni = scanner.nextLine();
    RepositorioClientes.getInstance().eliminarCliente(dni);
    System.out.println("Cliente eliminado");
  }

  private void buscarFacturasPorCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el dni del cliente");
    String dni = scanner.nextLine();
    List<Factura> facturas = RepositorioFacturas.getInstance().buscarFacturasPorCliente(dni);
    if (facturas.isEmpty()) {
      System.out.println("No se encontraron facturas para el cliente");
    } else {
      for (Factura factura : facturas) {
        System.out.println(factura);
      }
    }
  }

  private void agregarFactura() {
    //obtener datos
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el dni del cliente");
    String dni = scanner.nextLine();
    Cliente cliente = RepositorioClientes.getInstance().buscarCliente(dni);
    if (cliente == null) {
      System.out.println("No se encontro el cliente");
      return;
    }

    // Agregar items a la factura
    List<Item> items = new ArrayList<>();
    boolean agregarItems = true;
    do {
      System.out.println("Ingrese el nombre del item");
      String nombre = scanner.nextLine();
      System.out.println("Ingrese el precio del item");
      int precio = Integer.parseInt(scanner.nextLine());
      Item item = new Item(nombre, precio);
      items.add(item);
      System.out.println("Desea agregar otro item? (s/n)");
      String respuesta = scanner.nextLine();
      if (respuesta.equals("n")) {
        agregarItems = false;
      }
    } while (agregarItems);

    // creo la factura y la agrego al repo
    Factura factura = new Factura(cliente, items);
    if (RepositorioFacturas.getInstance().agregarItem(factura)) {
      System.out.println("Factura agregada");
    } else {
      System.out.println("No se encontro el cliente");
    }
  }

  private void imprimirClientes() {
    RepositorioClientes.getInstance().imprimirRepositorio();
  }


  public static void main(String[] args) {

    Main principal = new Main();
    principal.run();

  }
}