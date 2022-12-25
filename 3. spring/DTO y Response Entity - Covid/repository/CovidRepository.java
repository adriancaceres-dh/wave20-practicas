package com.bootcamp.test.repository;

import com.bootcamp.test.model.NivelDeGravedad;
import com.bootcamp.test.model.Persona;
import com.bootcamp.test.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class CovidRepository {

    public static List<Sintoma> listaSintomas = new ArrayList<>();
    public static List<Persona> listaPersonas = new ArrayList<>();


    public static void dummyData() {
        listaSintomas.add(new Sintoma("R2D2", "Granos", NivelDeGravedad.BAJO));
        listaSintomas.add(new Sintoma("A3A", "Fiebre", NivelDeGravedad.MEDIO));
        listaSintomas.add(new Sintoma("MESS1", "Gambeta", NivelDeGravedad.ALTO));
        listaSintomas.add(new Sintoma("D10S", "Inflamacion", NivelDeGravedad.MORTAL));

        listaPersonas.add(new Persona("1", "Roman", "Riquelme", 37));
        listaPersonas.add(new Persona("2", "Emiliano", "Martinez", 28));
        listaPersonas.add(new Persona("3", "Rodrigo", "Bentancur", 24));
    }


}
