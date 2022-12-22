package com.bootcamp;

public class Main {
    public static void main(String[] args){

        Auto auto = new Auto(200,150,30,"RM204");
        Moto moto = new Moto(500,200,65,"BM222");

        Carrera dakar = new Carrera(100,10000,"dakar",2);
        dakar.darDeAltaAuto(auto);
        dakar.darDeAltaMoto(moto);
        dakar.correrCarrera();
    }



}
