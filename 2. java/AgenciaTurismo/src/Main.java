import com.bootcamp.Agencia;
import com.bootcamp.AnalizadorLocalizadores;
import com.bootcamp.Cliente;
import com.bootcamp.Localizador;
import com.bootcamp.reservas.BoletoViaje;
import com.bootcamp.reservas.Comida;
import com.bootcamp.reservas.ReservaHotel;
import com.bootcamp.reservas.Transporte;

public class Main {
    public static void main(String[] args) {
        Agencia agenciaTurismo = new Agencia();
        Cliente cliente1 = new Cliente("Esteban", "38.409.333");

        Comida comida1 = new Comida("C-1", 450, 1, "Hamburguesa", true);
        BoletoViaje boletoViaje1 = new BoletoViaje("B-1", 100, 3, "Córdoba", "Santa Fé");
        ReservaHotel reservaHotel1 = new ReservaHotel("H-1", 2000, 1, "Luxor");
        Transporte transporte1 = new Transporte("T-1", 300, 2, "Hector M.", "Bus");

        Localizador localizador1 = new Localizador(cliente1);
        localizador1.addReserva(boletoViaje1);
        localizador1.addReserva(comida1);
        localizador1.addReserva(reservaHotel1);
        localizador1.addReserva(transporte1);

        System.out.println(agenciaTurismo.agregarLocalizador(localizador1));

        // - - - - - -

        BoletoViaje boletoViaje2 = new BoletoViaje("B-2", 100, 3, "Córdoba", "Santa Fé");
        ReservaHotel reservaHotel2 = new ReservaHotel("H-2", 2000, 1, "Luxor");
        BoletoViaje boletoViaje3 = new BoletoViaje("B-3", 100, 3, "Córdoba", "Santa Fé");
        ReservaHotel reservaHotel3 = new ReservaHotel("H-3", 2000, 1, "Luxor");

        Localizador localizador2 = new Localizador(cliente1);
        localizador2.addReserva(boletoViaje2);
        localizador2.addReserva(boletoViaje3);
        localizador2.addReserva(reservaHotel2);
        localizador2.addReserva(reservaHotel3);

        System.out.println(agenciaTurismo.agregarLocalizador(localizador2));

        // - - - - - -

        ReservaHotel reservaHotel4 = new ReservaHotel("H-4", 2000, 1, "Luxor");
        Localizador localizador3 = new Localizador(cliente1);
        localizador3.addReserva(reservaHotel4);

        System.out.println(agenciaTurismo.agregarLocalizador(localizador3));

        // - - - - - -

        AnalizadorLocalizadores analizadorLocalizadores = new AnalizadorLocalizadores();
        analizadorLocalizadores.addLocalizador(localizador1);
        analizadorLocalizadores.addLocalizador(localizador2);
        analizadorLocalizadores.addLocalizador(localizador3);

        System.out.println("Analisis total: ");
        System.out.println(analizadorLocalizadores.cantidadLocalizadoresVendidos());
        System.out.println(analizadorLocalizadores.cantidadTotalReservas());
        System.out.println(analizadorLocalizadores.cantidadTotalVentas());
        System.out.println(analizadorLocalizadores.promedioTotalVentas());

        // - - - - - - -
        System.out.println("Mapa de Reservas");
        System.out.println(analizadorLocalizadores.mapaReservas());

    }
}