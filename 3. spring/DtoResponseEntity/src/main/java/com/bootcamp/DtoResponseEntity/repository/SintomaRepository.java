package com.bootcamp.DtoResponseEntity.repository;

import com.bootcamp.DtoResponseEntity.dto.SintomaDTO;
import com.bootcamp.DtoResponseEntity.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomaRepository {

    List<Sintoma> sintomas = new ArrayList<>();


    public Sintoma guardarSintoma(Sintoma sintoma){
        sintomas.add(sintoma);
        return sintoma;
    }
    public Sintoma encontrarSintoma(String nombre){
        Optional<Sintoma> sintoma = sintomas.stream().filter(sintoma1 -> sintoma1.getNombre().equals(nombre)).findFirst();
        return sintoma.orElse(null);
    }
    public List<Sintoma> listaDeSintoma(){
        return sintomas;
    }
}
