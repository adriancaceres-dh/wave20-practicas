package com.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> guardaropa;
    Integer id;

    public GuardaRopa() {
        guardaropa = new HashMap<>();
        id = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        guardaropa.put(++id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas () {
        guardaropa.keySet().stream().forEach(k -> System.out.println("Prendas de " + k + "\n" + guardaropa.get(k)));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        System.out.println("Las prendas de " + numero + " son: ");
        System.out.println(guardaropa.get(numero));
        return guardaropa.get(numero);
    }
}
