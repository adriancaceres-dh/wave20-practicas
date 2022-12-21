import com.bootcamp.Carrera;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(200,300,"Dakar", 2);
        carrera.darDeAltaAuto(30,300,20,"AA-111-AA");
        carrera.darDeAltaAuto(27,250,25,"BB-222-BB");
        carrera.darDeAltaMoto(10,150,15,"BB-222-BB");

        System.out.println(carrera.determinarGanador());

        carrera.socorrerAuto("AA-111-AA");
        carrera.socorrerAuto("AA-111-AAz");

    }
}