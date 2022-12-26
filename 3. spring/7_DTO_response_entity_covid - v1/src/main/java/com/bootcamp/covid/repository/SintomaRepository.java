package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {
    private List<Sintoma> sintomas;
    public SintomaRepository() {
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("S1","Tos","Bajo"));
        sintomas.add(new Sintoma("S2","Fiebre","Medio"));
        sintomas.add(new Sintoma("S3","Presion alta","Alto"));
    }
    public List<Sintoma> sintomas() {
        return sintomas;
    }

}
