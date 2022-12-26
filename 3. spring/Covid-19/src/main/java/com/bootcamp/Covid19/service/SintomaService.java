package com.bootcamp.Covid19.service;

import com.bootcamp.Covid19.model.Persona;
import com.bootcamp.Covid19.model.Sintoma;

import java.util.*;
import java.util.stream.Collectors;

public class SintomaService {
    private final Map<Sintoma, List<Persona>> personaConSintoma;
    public SintomaService(){

        List<Persona> personaList = new ArrayList<>();
        personaList.add(new Persona(1L, "Lio", "Messi", 35));
        personaList.add(new Persona(2L, "Fideo", "DiMaria", 34));

        Sintoma sintoma1 = new Sintoma("codigo1", "Fiebre", "Moderado");
        Sintoma sintoma2 = new Sintoma("codigo2", "Dolor de cabeza", "Leve");


        personaConSintoma = new HashMap<>();
        personaConSintoma.put(sintoma1, personaList);
        personaConSintoma.put(sintoma2, personaList);

    }
    public List<String> encontrarSintomas() {
        Set<Sintoma> sintomas = personaConSintoma.keySet();
        return sintomas.stream().map(Sintoma::getNombre).collect(Collectors.toList());
    }

    public String encontrarSintoma(String sintoma){
        if(sintoma.isEmpty()){
            System.out.println("El sintoma no existe");
        }
        Sintoma sintomaEncontrado = personaConSintoma.keySet().stream().filter(elem -> elem.getNombre().equals(sintoma)).findFirst().orElse(null);
        assert sintomaEncontrado != null;
        return sintomaEncontrado.getNivel_de_gravedad();
    }
}
