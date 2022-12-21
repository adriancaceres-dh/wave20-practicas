import repositorios.FactoryRepositorioClientes;
import repositorios.FactoryRepositorioGenerico;
import repositorios.RepositorioClientes;
import repositorios.RepositorioGenerico;
import supermercado.Cliente;
import supermercado.Factura;
import supermercado.Item;
import supermercado.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RepositorioClientes repo = FactoryRepositorioClientes.get();
        repo.add(new Cliente("11111111", "María", "Gonzales"));
        repo.add(new Cliente("22222222", "Juan", "Pérez"));
        repo.add(new Cliente("33333333", "Raul", "Gómez"));

        System.out.println("Lista al principio");
        repo.buscarTodos().forEach(System.out::println);
        System.out.println("-------------------------");

        repo.remove(0);

        System.out.println("Lista tras remover un cliente");
        repo.buscarTodos().forEach(System.out::println);
        System.out.println("-------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar numero de DNI a buscar: ");
        String dniBuscado = scanner.nextLine();

        Optional<Cliente> clienteBuscado = repo.buscarPorDNI(dniBuscado);

        if (clienteBuscado.isPresent()) {
            System.out.println(clienteBuscado.get());
        } else {
            System.out.println("No se encontró al cliente buscado");
        }
        System.out.println("-------------------------");

        var clienteNuevo = new Cliente("44444444", "José", "López");
        var factura = new Factura(clienteNuevo);
        // Repositorio generico para CRUD
        RepositorioGenerico<Factura> repoFacturas = FactoryRepositorioGenerico.get(Factura.class);
        repoFacturas.add(factura);
        System.out.println("Clientes");
        repo.buscarTodos().forEach(System.out::println);
        List<Item> items = new ArrayList<>(List.of(
                new Item(5, new Producto("111", 23, "Jabon")),
                new Item(1, new Producto("112", 12, "Sal")),
                new Item(2, new Producto("333", 23, "Harina"))
        ));
        factura.addAllItems(items);
        System.out.println("Facturas");
        repoFacturas.buscarTodos().forEach(System.out::println);
        System.out.println("-------------------------");

        System.out.println("Total de la factura: " + factura.getTotal());
        System.out.println("-------------------------");
    }
}