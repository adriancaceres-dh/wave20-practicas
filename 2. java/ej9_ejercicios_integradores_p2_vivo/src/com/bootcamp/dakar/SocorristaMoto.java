package com.bootcamp.dakar;

public class SocorristaMoto implements ISocorrista<Moto>{

    public boolean socorrer(Moto moto){
        System.out.println("Socorriendo moto "+moto.getPatente());
        return true;
    }

}
