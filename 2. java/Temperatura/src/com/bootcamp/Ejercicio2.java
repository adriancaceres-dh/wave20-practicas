package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args){
        List<String> listaPersonas = new ArrayList<String>();
        listaPersonas.add("Cristiano Ronaldo");
        listaPersonas.add("Lionel Messi");

        for(String person : listaPersonas){
            System.out.println("Hola soy: " + person);
        }
        /*for(int i = 0; i<listaPersonas.size(); i++){
            System.out.println("Hola soy: " + listaPersonas.get(i));
        }*/
    }
    /*public static void main(String[] args){
        List<String> listaPersonas = new ArrayList<String>();
        listaPersonas.add("Cristiano Ronaldo");
        listaPersonas.add("Lionel Messi");

        for(int i = 0; i<listaPersonas.size(); i++){
            System.out.println("Hola soy: " + listaPersonas.get(i));
        }
    }*/



}
