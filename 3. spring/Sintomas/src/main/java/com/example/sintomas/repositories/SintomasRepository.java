package com.example.sintomas.repositories;

import com.example.sintomas.entities.Sintoma;
import com.example.sintomas.enums.NivelGravedadEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SintomasRepository {
    private static Set<Sintoma> Sintomas = new HashSet<>(
            List.of(new Sintoma(1, "Tos", NivelGravedadEnum.MEDIO),
                    new Sintoma(2, "Dolor muscular", NivelGravedadEnum.BAJO),
                    new Sintoma(3, "Dificultad respiratoria", NivelGravedadEnum.ALTO),
                    new Sintoma(4, "Fiebre", NivelGravedadEnum.MEDIO),
                    new Sintoma(5, "Congestion", NivelGravedadEnum.BAJO),
                    new Sintoma(1, "Perdida del olfato", NivelGravedadEnum.BAJO)));

    public static Set<Sintoma> getSintomas() {
        return Sintomas;
    }

    public static void agregarSintomas(Set<Sintoma> sintomas) {
        Sintomas.addAll(sintomas);
    }
    public static void eliminarSintomas(Set<Sintoma> sintomas) {
        Sintomas.removeAll(sintomas);
    }
}
