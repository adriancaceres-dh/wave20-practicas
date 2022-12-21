package com.bootcamp;

public class SocorristaMoto implements SocorrerInterface<Moto>{

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo la moto: " + moto.getPatente());
    }
}
