package com.covid19.covid19.service;

import com.covid19.covid19.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SintomaService {
    List<Sintoma> sintomas;
    public SintomaService(){
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("codigo_1","nombre_1","nivel 1"));
        sintomas.add(new Sintoma("codigo_2","nombre_2","nivel 2"));
        sintomas.add(new Sintoma("codigo_3","nombre_3","nivel 3"));
    }
    public Sintoma findByName(String nombre){
        Sintoma sintoma = sintomas.stream().filter(s->s.getNombre().equals(nombre)).findAny().orElse(null);
        return sintoma;
    }
    public List<Sintoma> findTodos(){
        return sintomas;
    }
}
