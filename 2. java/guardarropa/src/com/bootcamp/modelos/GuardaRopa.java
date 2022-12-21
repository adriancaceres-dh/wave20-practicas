package com.bootcamp.modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private final Map<Integer, List<Prenda>> mapaPrendas;

    public GuardaRopa() {
        this.contador = 0;
        this.mapaPrendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        mapaPrendas.put(++contador, prendas);
        return contador;
    }

    public void mostrarPrendas() {
        mapaPrendas.forEach((k,v) -> System.out.println("Número " + k + ": " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapaPrendas.get(numero);
    }
}
