package com.bootcamp.covid.service;

import com.bootcamp.covid.model.Sintoma;

import java.util.*;
import java.util.stream.Collectors;

public class SintomaService {
    public final List<Sintoma> sintomas;

    public SintomaService() {
        this.sintomas = new ArrayList<>(Arrays.asList(
                new Sintoma("FI", "fiebre", 3),
                new Sintoma("TO", "tos", 2),
                new Sintoma("DC", "dolor-cabeza", 1),
                new Sintoma("DG", "dolor-garganta", 2),
                new Sintoma("FA", "fatiga", 1),
                new Sintoma("NA", "nauseas", 3)
        ));
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public Optional<Sintoma> getSintoma(String nombreSintoma) {
        return sintomas.stream().filter(sintoma -> nombreSintoma.equals(sintoma.getNombre())).findFirst();
    }

    public Optional<Sintoma> getSintomaByCodigo(String codigoSintoma) {
        return sintomas.stream().filter(sintoma -> codigoSintoma.equals(sintoma.getCodigo())).findFirst();
    }

    public Set<String> getSintomasRiesgo() {
        return sintomas.stream().filter(sintoma -> sintoma.getNivelDeGravedad() == 3)
                .map(Sintoma::getCodigo).collect(Collectors.toSet());
    }
}
