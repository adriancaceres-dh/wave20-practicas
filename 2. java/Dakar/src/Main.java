import com.bootcamp.model.Auto;
import com.bootcamp.model.Carrera;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Carrera carrera1 = new Carrera(200.0, 5000.0, "Carrera", 7);
        carrera1.darDeAltaAuto(200.0, 100.0, 50.5, "AAA123");
        carrera1.darDeAltaAuto(150.0, 150.0, 30.5, "BBB456");
        carrera1.darDeAltaAuto(250.0, 50.0, 100.5, "CCC123");
        carrera1.darDeAltaAuto(175.0, 130.0, 150.5, "DDD123");
        carrera1.darDeAltaAuto(400.0, 150.0, 30.0, "BBB789");

        carrera1.darDeAltaMoto(190.0, 200.0, 200.0, "MMM123");
        carrera1.darDeAltaMoto(150.0, 100.0, 90.0, "MMM456");
        carrera1.darDeAltaMoto(150.0, 300.0, 100.0, "MMM789");

        carrera1.eliminarVehiculoConPatente("CCC123");

        carrera1.ganadores();


    }
}