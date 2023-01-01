package com.bootcamp.Covid_19.repository;

import com.bootcamp.Covid_19.models.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {
    List<Sintoma> listaDeSintomas;

    public SintomaRepository(){

        listaDeSintomas= new ArrayList<>();

        Sintoma tos = new Sintoma("001","Tos","Medio");
        Sintoma fiebre = new Sintoma("002","Fiebre","Bajo");
        Sintoma presionAlta = new Sintoma("003","Presion alta","Alto");
        Sintoma dolorCabeza = new Sintoma("004","Dolor de cabeza","Medio");
        Sintoma debilidadMuscular = new Sintoma("005","Debilidad muscular","Alto");

        listaDeSintomas.add(tos);
        listaDeSintomas.add(fiebre);
        listaDeSintomas.add(presionAlta);
        listaDeSintomas.add(dolorCabeza);
        listaDeSintomas.add(debilidadMuscular);

    }

    public List<Sintoma> getListaDeSintomas() {
        return listaDeSintomas;
    }
}
