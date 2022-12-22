package com.bootcamp;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>(
                Arrays.asList(new Cliente(37550240, "Francisco", "Berthet"),
                        new Cliente(287654300, "Nahuel", "Inventado"),
                        new Cliente(8888888, "Martin", "Trinidad")));


        System.out.println("-Clientes");
        clientes.forEach(c ->
                System.out.println("DNI: " + c.dni + ", Nombre: " + c.nombre + ", Apellido: " + c.apellido));

        System.out.println("eliminando cliente con DNI 37550240...");
        clientes = clientes.stream()
                .filter(e -> e.dni != 37550240)
                .collect(Collectors.toList());

        System.out.println("-Clientes");
        clientes.forEach(c ->
                System.out.println("DNI: " + c.dni + ", Nombre: " + c.nombre + ", Apellido: " + c.apellido));

        Scanner scanner = new Scanner(System.in);
        System.out.println("-Busqueda de clientes");
        boolean buscar = true;

        do {
            try {
                System.out.print("Ingrese dni de cliente a buscar: ");
                Integer dni = scanner.nextInt();
                clientes.stream().filter(e ->
                        e.dni.equals(dni)).findFirst().ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se encontro ningun cliente con ese DNI"));

                buscar = false;
            } catch (InputMismatchException e) {
                System.out.println("Formato invalido, por favor ingrese un numero de DNI a buscar");
                scanner.nextLine();
            }
        } while (buscar);


    ///// parte II
    List<Item> compraDelDia = new ArrayList<>(Arrays.asList(
            new Item(10.0,"021","manaos naranja",5),
            new Item(70,"003","medialunas de manteca",12),
            new Item(100,"001","Agua mineral villavicencio",2)
    ));

    System.out.println("-Nueva factura");
    String[] datosCliente = {"37550240", "Francisco", "Berthet"};

    Optional <Double> totalCompraDelDia = compraDelDia.stream()
            .map( i -> i.costoUnitario * i.cantidadComprada).reduce(Double::sum);

    if (totalCompraDelDia.isEmpty()) {
        System.out.println("no se pudo calcular el total de la compra del dia");
    }
    else {
        Factura factura = new Factura(compraDelDia, totalCompraDelDia.get()
                /* lo mismo que compraDelDia.stream().map(i -> i.costoUnitario * i.cantidadComprada).reduce((i,o )-> i+o)
                 */
                , clientes.stream().filter(e ->
                                e.dni.equals(Integer.parseInt(datosCliente[0])))
                .findFirst()
                .orElse(new Cliente(Integer.parseInt(datosCliente[0]),datosCliente[1],datosCliente[2])));
        System.out.println(factura);
    }









}
}
