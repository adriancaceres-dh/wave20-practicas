package com.bootcamp.ej_clases_abstractas;

import com.bootcamp.ej_clases_abstractas.Prototipo;
import com.bootcamp.ej_clases_abstractas.SerieDe3;

public class Main {

    public static void main(String[] args) {


        Prototipo serie3 = new SerieDe3();

        serie3.establecerValorInicial(-12.0);

        for (int i=0;i<=10;i++) System.out.println(serie3.devolverSiguiente());

        serie3.reiniciarSerie();

        System.out.println(serie3.devolverSiguiente());


    }
}
