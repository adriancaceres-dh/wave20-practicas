package com.example.edadPersona.service;

import com.example.edadPersona.entity.Sintoma;

import java.util.*;
import java.util.stream.Collectors;

public class SintomaService {
    public List<Sintoma> sintomaList;
    public SintomaService() {
        this.sintomaList = new ArrayList<>(Arrays.asList(
                new Sintoma("FI", "fiebre", 3),
                new Sintoma("TO", "tos", 2),
                new Sintoma("DC", "dolor-cabeza", 1),
                new Sintoma("DG", "dolor-garganta", 2),
                new Sintoma("FA", "fatiga", 1),
                new Sintoma("NA", "nauseas", 3)
        ));
    }
    public List<Sintoma> sintomaList(){
        return sintomaList;
    }
    public Optional<Sintoma> getSintoma(String nombreSintoma){
        return sintomaList.stream().filter(n -> nombreSintoma.equals(n.getNombre())).findFirst();
    }
    public Optional<Sintoma> getSintomaByCode(String codigo){
        return sintomaList.stream().filter(n -> codigo.equals(n.getCodigo())).findFirst();
    }
    public Set<Sintoma> getSintomasRiesgo(){
        Set<Sintoma> sintomasRiesgo = new HashSet<>();
        return sintomaList.stream().filter(sintoma -> sintoma.getNivel_de_gravedad().equals(3)).collect(Collectors.toSet());
    }
}
