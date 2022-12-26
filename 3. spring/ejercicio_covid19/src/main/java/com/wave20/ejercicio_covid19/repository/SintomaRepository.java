package com.wave20.ejercicio_covid19.repository;

import com.wave20.ejercicio_covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {

    List<Sintoma> sintomas = new ArrayList<>();

    public SintomaRepository() {
        sintomas.add(new Sintoma(1,
                "Fiebre", "alto"));
        sintomas.add(new Sintoma(2,
                "Dolor de cabeza", "bajo"));
        sintomas.add(new Sintoma(3,
                "Malestar estomacal", "medio"));

    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }
}
