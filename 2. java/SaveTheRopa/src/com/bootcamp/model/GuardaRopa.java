package com.bootcamp.model;

import java.util.*;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> lista){
        contador++;
        prendas.put(contador, lista);
        return contador;
    }
    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> prenda : prendas.entrySet()){
            Integer clave = prenda.getKey();
            List<Prenda> prendas = prenda.getValue();
            System.out.println(clave + " -> " + prendas);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) throws Exception {
        List<Prenda> pren = prendas.get(numero);
        if(!prendas.containsKey(numero)){
            throw new Exception("No hay prendas para ese codigo");
        }
        return pren;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
