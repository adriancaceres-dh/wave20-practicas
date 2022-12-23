package com.bootcamp.Covid19.Service;

import com.bootcamp.Covid19.Model.Sintomas;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SintomasService {
    List<Sintomas> listaSintomas = new LinkedList<>();

    public String mostrarSintomas(){
        String devolver = "";

        for (int i = 0; i < listaSintomas.size(); i++) {
            devolver += listaSintomas.get(i) + "\n";
        };

        return devolver;
    }

    public String consultaSintoma(String nombreSintoma){
        //List<Sintomas> encontrarSintoma = listaSintomas.stream().collect(x->x.getNombre().equals(nombreSintoma));
        for (Sintomas actual : listaSintomas) {
            if(actual.getNombre().equals(nombreSintoma)){
                return actual.getNivel_de_gravedad();
            }
        }
        return null;
    }
}
