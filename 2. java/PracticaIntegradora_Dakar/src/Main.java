public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(200,300,"Dakar", 3);
        carrera.darDeAltaAuto(20,20,20,"TID098");
        carrera.darDeAltaAuto(20,230,202,"PDD754");
        carrera.darDeAltaMoto(100, 300, 90, "KKP524");
        Auto auto= new Auto(240, 120, 70, "OKW998");
        carrera.getVehiculos().add(auto);
        Moto moto= new Moto(200, 90, 60, "OPL898");
        carrera.getVehiculos().add(moto);
        carrera.eliminarVehiculo(auto);
        carrera.eliminarVehiculoConPatente("OPL898");

        System.out.println(carrera.determinarGanador());

    }
}