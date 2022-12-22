import dakar.Carrera;
import dakar.socorrista.SocorristaAuto;
import dakar.socorrista.SocorristaMoto;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(
                100,
                2000,
                "Una re carrera",
                2,
                new SocorristaAuto(),
                new SocorristaMoto()
        );
        carrera.darDeAltaAuto(100, 10, 10, "asd123");
        carrera.darDeAltaMoto(90, 5, 10, "abc456");

        System.out.println("Ganador: " + carrera.vehiculoGanador());
    }
}