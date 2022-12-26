package com.bootcamp._dto_p2.repository;

import com.bootcamp._dto_p2.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {

    private static List<Sintoma> listaSintomas = new ArrayList<>();

    public static List<Sintoma> getAll(){
        return listaSintomas;
    }

    public static boolean contiene(String nombre){
        return listaSintomas.stream()
                .anyMatch(sintoma -> sintoma.getNombre().equals(nombre));
    }

    public static String getGravedadByName(String name) {
        try {
            return listaSintomas.stream()
                    .filter(sintoma -> sintoma.getNombre().equals(name))
                    .findFirst().orElse(null).getNivel_de_gravedad();

        } catch (Exception e){
            return null;
        }
    }

    public static boolean addAll(List<Sintoma> sintomas) {
        return listaSintomas.addAll(sintomas);
    }
}
