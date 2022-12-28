package com.bootcamp.EjercicioCovid19.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcamp.EjercicioCovid19.models.Sintoma;
import org.springframework.stereotype.Repository;


@Repository
public class SintomaRepository {

    List<Sintoma> sintomas ;

    public SintomaRepository (){
        sintomas = new ArrayList<>();

        sintomas.add(new Sintoma("nausea",1,3));
        sintomas.add(new Sintoma("vómito",2,5));
        sintomas.add(new Sintoma("tos",3,1));
        sintomas.add(new Sintoma("cansancio",4,2));
        sintomas.add(new Sintoma("dolor muscular",5,3));

    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public Sintoma busquedaSintoma(String nombre){
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(nombre)).collect(Collectors.toList()).get(0);
    }
}
