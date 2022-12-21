package com.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> ropero;

    private int identificador;

    public GuardaRopa() {
        this.identificador = 0;
        this.ropero = new HashMap<Integer, List<Prenda>>();
    }

    public Map<Integer, List<Prenda>> getRopero() {
        return ropero;
    }

    public void setRopero(Map<Integer, List<Prenda>> ropero) {
        this.ropero = ropero;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "ropero=" + ropero +
                ", identificador=" + identificador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        ropero.put(++identificador, listaDePrendas);
        return identificador;
    }

    public void mostrarPrendas(){
        ropero.forEach((key,value)-> System.out.println(key + " : " + value));
    }

    public List<Prenda> devolverPrendas(Integer numero){

        if (ropero.containsKey(numero)) return ropero.get(numero);
        return null;
    }
}
