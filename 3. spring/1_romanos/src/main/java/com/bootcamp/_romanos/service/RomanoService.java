package com.bootcamp._romanos.service;

import com.bootcamp._romanos.model.Romano;

public class RomanoService {

    public static String convertir (Integer numero){
        int valorKey= Romano.mapaRomanos.floorKey(numero);
        if(numero==valorKey){
            return Romano.mapaRomanos.get(numero);
        }
        return Romano.mapaRomanos.get(valorKey)+convertir(numero-valorKey);
    }

}
