package com.bootcamp.clases;

import java.util.*;

public class GuardaRopa {


    private Map<Integer, List<Prenda>> colecionesPrendas;
    public int contador;

    public GuardaRopa() {
        colecionesPrendas = new HashMap<>();
        this.contador = 0;
    }


    /*
    Método guardarPrendas recibe una lista de prendas y devuelve
    el número identificador en donde quedaron asignadas las prendas,
    es decir la clave del diccionario en donde guardamos las mismas.
     */

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador ++;
        colecionesPrendas.put(contador, listaDePrenda);
        return contador;
    }



    /*
    Método mostrarPrendas imprime por pantalla todas las prendas
    que quedan en el guardarropas junto con el número que les corresponde.

     */
    public void mostrarPrendas() {
        colecionesPrendas.entrySet()
                .stream()
                .forEach(e->System.out.println(e.getKey()+" "+e.getValue()));


    }


    /*
    Método devolverPrendas devuelve la lista de prendas que están guardadas bajo ese número.
     */
    public List<Prenda> devolverPrendas(Integer numero) {
        return colecionesPrendas.get(numero);
    }


}
