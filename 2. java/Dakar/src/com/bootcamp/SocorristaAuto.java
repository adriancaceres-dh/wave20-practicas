package com.bootcamp;

public class SocorristaAuto implements SocorrerInterface<Auto> {

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo el auto " + auto.getPatente());
    }
}
