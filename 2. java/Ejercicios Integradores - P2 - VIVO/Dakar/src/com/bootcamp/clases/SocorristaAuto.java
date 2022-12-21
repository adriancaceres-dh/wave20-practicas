package com.bootcamp.clases;

import com.bootcamp.interfaces.ISocorrer;

public class SocorristaAuto implements ISocorrer<Auto> {
    @Override
    public void socorrer(Auto elemento) {
        System.out.println("Socorriendo auto: " + elemento.getPatente());
    }
}
