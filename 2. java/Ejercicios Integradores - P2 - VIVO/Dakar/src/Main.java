import com.bootcamp.clases.Carrera;
import com.bootcamp.clases.SocorristaAuto;
import com.bootcamp.clases.SocorristaMoto;
import com.bootcamp.clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Carrera carrera = new Carrera(5000, 25000, "Dakar", 10, socorristaAuto, socorristaMoto);
        carrera.darDeAltaAuto(250, 180, 70, "MA158");
        carrera.darDeAltaAuto(300, 150, 60, "LA63");
        carrera.darDeAltaAuto(250, 170, 50, "KJ18");
        carrera.darDeAltaMoto(200, 175, 70, "SD14");
        carrera.darDeAltaMoto(150, 100, 80, "LO63");
        carrera.darDeAltaMoto(140, 100, 80, "KM14");
        carrera.eliminarVehiculoConPatente("KM14");
        carrera.eliminarVehiculoConPatente("AS26");
        System.out.println(carrera);
        System.out.println(carrera.obtenerGanador());
        if (!carrera.socorrerMoto("LO63")) {
            System.out.println("No existe la patente ingresada.");
        }
        if (!carrera.socorrerAuto("KJ18")) {
            System.out.println("No existe la patente ingresada.");
        }
        if (!carrera.socorrerAuto("16516")) {
            System.out.println("No existe la patente ingresada.");
        }

    }
}