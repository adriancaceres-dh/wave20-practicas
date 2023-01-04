package com.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> prendas;
    int id;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.id = 0;
    }

    public Map<Integer, List<Prenda>> getPrendas() { return prendas; }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) { this.prendas = prendas; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int guardarPrendas(List<Prenda> listaDePrenda) {
        int key = ++id;
        prendas.put(key ,listaDePrenda);
        return key;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> pg: prendas.entrySet()) {
            System.out.println(pg.getKey() +" - "+pg.getValue());
        }
    }

    public List<Prenda> devolverPrendas(int id) {
        return prendas.remove(id);
    }

}
