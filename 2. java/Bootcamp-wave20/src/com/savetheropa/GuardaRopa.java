package com.savetheropa;

import com.savetheropa.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static int id = 1;
    Map<Integer, List<Prenda>> mapaPrendas;

    public GuardaRopa() {
        mapaPrendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        mapaPrendas.put(id, listaDePrendas);
        return id++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer,List<Prenda>> entrada : mapaPrendas.entrySet()) {
            System.out.println(String.format("Identificador Nro %d", entrada.getKey()));
            entrada.getValue().stream().forEach(p -> System.out.println(p.toString()));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapaPrendas.get(numero);
    }
}

