package com.bootcamp.Hospital.repository;
import com.bootcamp.Hospital.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomaRepository {

    List<Sintoma> sintomas = new ArrayList<>();



    public Sintoma saveSymptom(Sintoma sintoma){
        sintomas.add(sintoma);
        return sintoma;
    }

    public Sintoma findSymptom(String nombre){
        Optional<Sintoma> sintoma = sintomas.stream().filter(s -> s.getNombre().equals(nombre)).findFirst();
        return sintoma.isPresent() ? sintoma.get(): null;
    }

    public List<Sintoma> findAllSymptom(){
        return sintomas;
    }

}
