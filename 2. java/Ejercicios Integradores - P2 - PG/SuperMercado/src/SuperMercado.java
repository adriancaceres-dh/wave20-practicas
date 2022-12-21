import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Factura;
import com.bootcamp.clases.Producto;
import com.bootcamp.repositosio.RepositorioCliente;
import com.bootcamp.repositosio.RepositorioFactura;
import com.bootcamp.repositosio.RepositorioProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperMercado {

    public static void main(String[] args) {
//        List<Cliente> listaCliente = new ArrayList<>();
//        List<Factura> listaFacturas = new ArrayList<>();
//        Cliente cliente1 = new Cliente("1478526-4", "Juan", "López");
//        Cliente cliente2 = new Cliente("2547896-1", "Raúl", "Rodríguez");
//        Cliente cliente3 = new Cliente("4587126-2", "José", "Pérez");
//        listaCliente.add(cliente1);
//        listaCliente.add(cliente2);
//        listaCliente.add(cliente3);
//        for (Cliente c : listaCliente) {
//            System.out.println(c);
//        }
//        System.out.println("-----------Eliminar 1 cliente------------");
//        listaCliente.remove(1);
//        for (Cliente c : listaCliente) {
//            System.out.println(c);
//        }
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Entre el DNI del cliente");
//            System.out.println("Ingrese 'exit' para salir");
//            String dni = scanner.next();
//            if (dni.equalsIgnoreCase("exit")) break;
//            List<Cliente> clientesEncontradoss = existeCliente(listaCliente, dni);
//            if (clientesEncontradoss == null || clientesEncontradoss.size() == 0) {
//                System.out.println("El DNI ingresado no coicide con ninguno del listado de clientes.");
//            } else {
//                clientesEncontradoss.forEach(System.out::println);
//            }
//        }
//
//        List<Producto> listaProductos = new ArrayList<>();
//        Producto producto1 = new Producto("485", "Refresco de Cola", 3,125.0);
//        Producto producto2 = new Producto("147", "Galletas Oreo", 4,100);
//        Producto producto3 = new Producto("123", "Detergente Líquido", 2,150.0);
//        Producto producto4 = new Producto("400", "Jabón Palmolive", 8,35.0);
//        listaProductos.add(producto1);
//        listaProductos.add(producto2);
//        listaProductos.add(producto3);
//        listaProductos.add(producto4);
//        Factura factura = new Factura(cliente1, listaProductos);
//        factura.calcularTotalCompra();
//        if (existeCliente(listaCliente, cliente1.getDni()).size() == 0) {
//            listaCliente.add(cliente1);
//        }
//        listaFacturas.add(factura);

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioFactura repositorioFactura = new RepositorioFactura();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese una de las opciones: ");
            System.out.println("1- Mostrar listado de clientes.");
            System.out.println("2- Mostrar listado de facturas.");
            System.out.println("3- Verificar cliente por DNI.");
            System.out.println("4- Eliminar cliente por DNI.");
            System.out.println("5- Agregar nuevo cliente.");
            System.out.println("6- Agregar nueva factura.");
            System.out.println("0- Salir.");

            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    try {
                        repositorioCliente.getListaClientes().stream().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("No se han ingresado clientes aún");
                    }
                    break;
                case 2:
                    try {
                        repositorioFactura.getListaFactura().stream().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("No se han ingresado facturas aún");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el DNI del cliente a buscar:");
                    String dniBuscar = scanner.next();
                    try {
                        List<Cliente> clientesEncontrados = repositorioCliente.existeCliente(dniBuscar);
                        if (clientesEncontrados.size() > 0) {
                            clientesEncontrados.stream().forEach(System.out::println);
                        } else {
                            System.out.println("Cliente no encontrado");
                        }
                    } catch (Exception e) {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el DNI del cliente a eliminar:");
                    String dniEliminar = scanner.next();
                    try {
                        List<Cliente> clientesAEliminar = repositorioCliente.existeCliente(dniEliminar);
                        if (clientesAEliminar.size() > 0) {
                            clientesAEliminar.stream().forEach(System.out::println);
                            repositorioCliente.getListaClientes().removeAll(clientesAEliminar);
                        } else {
                            System.out.println("Cliente no encontrado");
                        }
                    } catch (Exception e) {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el DNI del cliente:");
                    String dni = scanner.next();
                    System.out.println("Ingrese el Nombre del cliente:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el Apellido del cliente:");
                    String apellido = scanner.next();
                    Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
                    System.out.println(nuevoCliente.toString());
                    repositorioCliente.adicionarElemento(nuevoCliente);
                    break;
                case 6:
                    System.out.println("Ingrese el DNI del cliente:");
                    String dniAbuscar = scanner.next();
                    List<Cliente> clienteEncontrado = repositorioCliente.existeCliente(dniAbuscar);
                    Cliente clienteAFacturar;
                    if (clienteEncontrado != null && clienteEncontrado.size() > 0) {
                        clienteAFacturar = clienteEncontrado.get(0);
                    } else {
                        System.out.println("Ingrese el Nombre del cliente:");
                        String nombreCliente = scanner.next();
                        System.out.println("Ingrese el Apellido del cliente:");
                        String apellidoCliente = scanner.next();
                        clienteAFacturar = new Cliente(dniAbuscar, nombreCliente, apellidoCliente);
                        repositorioCliente.adicionarElemento(clienteAFacturar);
                        RepositorioProducto repositorioProducto = new RepositorioProducto();
                        while (true) {
                            System.out.println("Ingrese una de las opciones: ");
                            System.out.println("1- Agregar nuevo producto");
                            System.out.println("2- Mostrar listado de productos.");
                            System.out.println("3- Eliminar producto por código.");
                            System.out.println("0- Pagar.");
                            int opcionCompra = scanner.nextInt();
                            switch (opcionCompra) {
                                case 1:
                                    System.out.println("Ingrese el código del producto:");
                                    String codigo = scanner.next();
                                    System.out.println("Ingrese el nombre del producto:");
                                    scanner.nextLine();
                                    String nombreProducto = scanner.nextLine();
                                    System.out.println("Ingrese la cantidad del producto:");
                                    int cantidad = scanner.nextInt();
                                    System.out.println("Ingrese el costo del producto:");
                                    double costo = scanner.nextDouble();
                                    Producto nuevoProducto = new Producto(codigo, nombreProducto, cantidad, costo);
                                    repositorioProducto.adicionarElemento(nuevoProducto);
                                    break;
                                case 2:
                                    repositorioProducto.getListaProductos().stream().forEach(System.out::println);
                                    break;
                                case 3:
                                    System.out.println("Ingrese el código del producto a eliminar:");
                                    String codigoEliminar = scanner.next();
                                    List<Producto> productosAEliminar = repositorioProducto.existeProducto(codigoEliminar);
                                    if (productosAEliminar.size() > 0) {
                                        productosAEliminar.stream().forEach(System.out::println);
                                        repositorioProducto.getListaProductos().removeAll(productosAEliminar);
                                    } else {
                                        System.out.println("Producto no encontrado");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            Factura factura = new Factura(clienteAFacturar, repositorioProducto.getListaProductos());
                            factura.calcularTotalCompra();
                            repositorioFactura.adicionarElemento(factura);
                            if (opcionCompra == 0) break;
                        }
                    }
                    break;
                default:
                    break;
            }

        }

    }

}
