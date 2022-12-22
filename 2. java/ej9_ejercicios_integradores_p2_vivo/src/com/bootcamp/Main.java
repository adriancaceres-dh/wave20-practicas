package com.bootcamp;

import com.bootcamp.dakar.*;
import com.bootcamp.savetheropaSA.modelo.Prenda;
import com.bootcamp.savetheropaSA.modelo.GuardaRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //SAVETHEROPA

        Prenda prenda1= new Prenda("marca1","modelo1");
        Prenda prenda2= new Prenda("marca2","modelo2");

        GuardaRopa GR= new GuardaRopa();

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);

        GR.guardarPrendas(listaPrendas);
        GR.guardarPrendas(listaPrendas);

        GR.mostrarPrendas();

        System.out.println(GR.devolverPrendas(1));



        //DAKAR

        Carrera car= new Carrera(100,5000,"DAKAR",20);

        car.darDeAltaAuto(30,30,90,"ASD123");
        car.darDeAltaMoto(25,35,100,"QWE456");
        car.darDeAltaAuto(35,37,30,"ZXC789");

        boolean x = car.eliminarVehiculoConPatente("QWE456");

        car.getListaVehiculos().stream().forEach(v->System.out.println(v.getPatente()));

        car.socorrerMoto("QWE456");


    }
}
