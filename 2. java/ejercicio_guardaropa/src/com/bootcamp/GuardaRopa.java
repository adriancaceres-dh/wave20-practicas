package com.bootcamp;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa(HashMap<Integer, List<Prenda>> diccionario, int contador) {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    public GuardaRopa() {
        contador = 0;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contador++;
        this.diccionario.put(contador,listaDePrendas);
        return contador;
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

    public void mostrarPrendas(){
        System.out.println("-----  Lista de prendas en el guardaropa ----- ");
        for (Map.Entry<Integer, List<Prenda>> entrada : diccionario.entrySet()
             ) {

            System.out.println("Identificador : "+entrada.getKey() +" - Prendas :"+entrada.getValue().toString());
        }
        System.out.println("---------------------------------------------");
    }

}
