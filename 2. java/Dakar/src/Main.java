import model.Carrera;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(15,1000000,"Grand Prix Rio de Janeiro",20);

        carrera.darDeAltaAuto(100,20,30,"AA50025");
        carrera.darDeAltaMoto(80,30,50,"AD540MV");

        carrera.imprimirVehiculosAnotados();

        carrera.eliminarVehiculoConPatente("AD540MV");
    }
}
