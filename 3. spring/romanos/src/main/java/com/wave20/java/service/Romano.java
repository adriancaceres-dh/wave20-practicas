package com.wave20.java.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class Romano {


    public static String romanize(int n) {

        String Unidad[]={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String Decena[]={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String Centena[]={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        int u=n%10;
        int d=(n/10)%10;
        int c=n/100;
        if(n>=100){
            return Centena[c]+Decena[d]+Unidad[u];
        }else{
            if(n>=10){
                return Decena[d]+Unidad[u];
            }else{
                return Unidad[n];
            }
        }
    }
}



