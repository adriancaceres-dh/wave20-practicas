package Bootcamp.Dakar;

public class Main {
    public static void main(String[] args) {
        Auto a1 = new Auto("FAG540");
        Auto a2 = new Auto("HAX402");
        Moto m1 = new Moto("POC389");
        Moto m2 = new Moto("TLX103");

        Carrera monza = new Carrera(321.7, 2500000,"Monza",20);

        monza.darDeAltaAuto(320,60,60,"FAG540");
        monza.darDeAltaAuto(315,70,54,"HAX402");
        monza.darDeAltaMoto(260,95,120,"POC389");
        monza.darDeAltaMoto(280,90,120,"TLX103");

        System.out.println(monza.toString());

        monza.eliminarVehiculoConPatente("TLX103");
        monza.eliminarVehiculoConPatente("FAG540");

        System.out.println(monza.toString());
    }
}