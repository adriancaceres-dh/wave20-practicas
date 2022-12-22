package com.dakar;

public class App {


        public static void main(String[] args) {
            Auto a1 = new Auto("FAG540");
            Auto a2 = new Auto("HAX402");
            Moto m1 = new Moto("POC389");
            Moto m2 = new Moto("TLX103");

            Carrera carrera = new Carrera(321.7, 2500000,"Monza",20);

            carrera.darDeAltaAuto(320,60,60,"FAG540");
            carrera.darDeAltaAuto(315,70,54,"HAX402");
            carrera.darDeAltaMoto(260,95,120,"POC389");
            carrera.darDeAltaMoto(280,90,120,"TLX103");

            System.out.println(carrera.toString());

            carrera.eliminarVehiculoConPatente("TLX103");
            carrera.eliminarVehiculoConPatente("FAG540");

            System.out.println(carrera.toString());
        }

}
