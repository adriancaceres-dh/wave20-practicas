package com.bootcamp.clases;

import com.bootcamp.interfaces.ISocorrer;

public class SocorristaMoto implements ISocorrer<Moto> {
    @Override
    public void socorrer(Moto elemento) {
        System.out.println("Socorriendo moto: " + elemento.getPatente());
    }
}
