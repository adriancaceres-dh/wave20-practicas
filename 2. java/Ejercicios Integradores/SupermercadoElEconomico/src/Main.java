import org.ietf.jgss.GSSName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Nombre 1", "Apellido 1");
        Cliente cliente2 = new Cliente("2", "Nombre 2", "Apellido 2");
        Cliente cliente3 = new Cliente("3", "Nombre 3", "Apellido 3");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("mostrar los datos de los clientes");
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));

        System.out.println("\n eliminar uno de lo clientes y mostrar los datos de los clientes");
        clientes.remove(cliente2);
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));

        while(true) {
            System.out.println("Menu: ");
            System.out.println("1 - Crear Cliente \n2 - Buscar Cliente \n3 - Modificar Cliente \n4 - Eliminar Cliente \n5 - Mostrar clientes \n6 - Salir");
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.next();
            if (opcion.equals("1")) {
                System.out.println("Ingrese dni");
                String dni = scanner.next();

                System.out.println("Ingrese nombre");
                String nombre = scanner.next();

                System.out.println("Ingrese apellido");

                String apellido = scanner.next();

                clientes.add(new Cliente(dni, nombre, apellido));
            }
            if (opcion.equals("2")) {
                System.out.println("Ingrese dni");
                String dniBuscar = scanner.next();
                Cliente clienteBuscado = buscarCliente(dniBuscar);
                if (clienteBuscado != null) {
                    System.out.println(clienteBuscado.toString());
                } else {
                    System.out.println("Cliente no encontrado");
                }
            }
            if (opcion.equals("3"))
            {
                System.out.println("Ingrese dni");
                String dniModificar = scanner.next();
                Cliente clienteBuscadoModificar = buscarCliente(dniModificar);
                if (clienteBuscadoModificar != null) {
                    System.out.println("1 - Modificar dni \n2 - Modificar nombre \n3 - Modificar apellido \n4 - Salir");
                    String opcionModificar = scanner.next();
                    switch (opcionModificar) {
                        case "1":
                            System.out.println("Ingrese nuevo dni");
                            String dniNuevo = scanner.next();
                            clienteBuscadoModificar.setDni(dniNuevo);
                            break;
                        case "2":
                            System.out.println("Ingrese nuevo nombre");
                            String nombreNuevo = scanner.next();
                            clienteBuscadoModificar.setNombre(nombreNuevo);
                            break;
                        case "3":
                            System.out.println("Ingrese nuevo apellido");
                            String apellidoNuevo = scanner.next();
                            clienteBuscadoModificar.setApellido(apellidoNuevo);
                            break;
                        case "4":
                        default:
                            break;
                    }
                } else {
                    System.out.println("Cliente no encontrado");
                }
            }
            if (opcion.equals("4")) {

                System.out.println("ingrese dni del cliente a eliminar");
                String dniEliminar = scanner.next();
                Cliente clienteBuscadoEliminar = buscarCliente(dniEliminar);
                if (clienteBuscadoEliminar != null) {
                    clientes.remove(clienteBuscadoEliminar);
                } else {
                    System.out.println("Cliente no encontrado");
                }
            }
            if (opcion.equals("5"))
                clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));
            if (opcion.equals("6"))
                break;
        }

    }
    public static Cliente buscarCliente(String dni){
        List<Cliente> clientesBuscados = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).collect(Collectors.toList());
        if(clientesBuscados.size() >= 1){
            return clientesBuscados.get(0);
        }else{
            return null;
        }
    }

}