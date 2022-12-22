import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1,"Pepe");

        List<Reserva> reservas = new ArrayList<Reserva>();
        reservas.add(cliente.HacerReserva(1, "Viaje", cliente));
        reservas.add(cliente.HacerReserva(2, "Cena", cliente));
        reservas.add(cliente.HacerReserva(3, "Comida", cliente));

        Localizador localizador = new Localizador( 1,reservas);

        List<Reserva> listaDeReservas = localizador.getReservas();
        listaDeReservas.stream().forEach(r -> System.out.println("Reserva -> "+ r.getId() + " : " + r.getTipo() + " -> Cliente: " + r.getCliente().getNombre()));

        System.out.println(" Localizadores: ");

    }
}