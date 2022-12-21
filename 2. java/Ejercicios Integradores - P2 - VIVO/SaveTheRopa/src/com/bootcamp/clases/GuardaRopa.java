package com.bootcamp.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    Map<Integer, List<Prenda>> prendas;
    static int id = 1;

    public GuardaRopa() {
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(id, listaDePrenda);
        return id++;
    }

    public void mostrarPrendas(){
        prendas.entrySet().stream().map(x-> x.getKey() +" - " + x.getValue()).forEach(System.out::println);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                '}';
    }
}
