import Clases.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Julian Alvarez",42192987);
        Cliente cliente2 = new Cliente("Lionel Messi",42192984);

        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();
        Carrito carrito3 = new Carrito();

        carrito1.addReserva(new Viaje(1000));
        carrito1.addReserva(new Comida(1500));
        carrito1.addReserva(new Hotel(2000));
        carrito1.addReserva(new Boleto(2000));

        carrito2.addReserva(new Viaje(1000));
        carrito2.addReserva(new Viaje(1500));
        carrito2.addReserva(new Hotel(2000));
        carrito2.addReserva(new Hotel(2000));

        carrito3.addReserva(new Hotel(2000));

        Agencia.realizarCompra(cliente,carrito1);
        Agencia.realizarCompra(cliente,carrito2);
        Agencia.realizarCompra(cliente,carrito3);

        System.out.println("Cantidad de localizadores vendidos: " + Agencia.cantidadDeLocalizadoresVendidos());
        System.out.println("Cantidad de reservas vendidas: " + Agencia.cantidadDeReservasVendidos());
        System.out.println("Total de ventas: " + Agencia.totalDeVentas());

        //Falta implementar el diccionario (seria similar al descuento por 2 hoteles o viajes)
        //Falta implementar el average creo que habia una funcion de stream que lo permitia



    }
}
