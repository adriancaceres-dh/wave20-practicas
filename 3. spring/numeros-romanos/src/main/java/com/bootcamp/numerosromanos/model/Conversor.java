package com.bootcamp.numerosromanos.model;

import java.util.Map;

public class Conversor {

    public static String convertirNumero(int n){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder numeroConvertido = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(n >= values[i])
            {
                n = n - values[i];
                numeroConvertido.append(numerosRomanos[i]);
            }
        }
        return numeroConvertido.toString();
    }
}

