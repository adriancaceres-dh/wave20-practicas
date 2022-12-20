import supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("11111111", "María", "Gonzales"),
                new Cliente("22222222", "Juan", "Pérez"),
                new Cliente("33333333", "Raul", "Gómez")
        ));

        System.out.println("Lista al principio");
        clientes.forEach(System.out::println);
        System.out.println("-------------------------");

        clientes.remove(clientes.size() - 1);

        System.out.println("Lista tras remover un cliente");
        clientes.forEach(System.out::println);
        System.out.println("-------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar numero de DNI a buscar: ");
        String dniBuscado = scanner.nextLine();

        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter( c -> c.getDni().equals(dniBuscado) )
                .findAny();

        if(clienteBuscado.isPresent()) {
            System.out.println(clienteBuscado.get());
        } else {
            System.out.println("No se encontró al cliente buscado");
        }
    }
}