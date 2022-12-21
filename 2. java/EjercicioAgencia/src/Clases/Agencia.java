package Clases;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    private static RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();
    private static RepositorioClientes repositorioClientes = new RepositorioClientes();

    public static boolean realizarCompra(Cliente cliente, Carrito carrito){
        System.out.println("Realizando compra para " + cliente);
        repositorioClientes.agregarClienteARepositorio(cliente);
        System.out.println("Total sin descuentos: " + carrito.calcularPrecioSinDescuentos());
        double precioConDescuentos = carrito.calcularPrecio(cliente);
        repositorioLocalizadores.crearLocalizador(cliente,precioConDescuentos,carrito);
        System.out.println("Compra realizada por el monto: " + precioConDescuentos);
        System.out.println("-----------------------------------------------------");

        return true;
    }


    public static boolean esClienteFrecuente(Cliente cliente) {
        return repositorioLocalizadores.esClienteFrecuente(cliente);
    }

    public static int cantidadDeLocalizadoresVendidos() {
        return repositorioLocalizadores.cantidadDeLocalizadores();
    }

    public static int cantidadDeReservasVendidos() {
        return repositorioLocalizadores.cantidadDeReservas();
    }

    public static double totalDeVentas() {
        return repositorioLocalizadores.totalDeVentas();

    }
}
