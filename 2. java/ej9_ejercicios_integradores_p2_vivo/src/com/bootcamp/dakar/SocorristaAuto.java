package com.bootcamp.dakar;

public class SocorristaAuto implements ISocorrista<Auto>{

    public boolean socorrer(Auto auto){
        System.out.println("Socorriendo auto "+auto.getPatente());
        return true;
    }

}
