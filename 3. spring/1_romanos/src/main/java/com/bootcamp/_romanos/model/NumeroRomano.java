package com.bootcamp._romanos.model;

import java.util.HashMap;
import java.util.Map;

public class NumeroRomano {

    private final static Map<Integer, String> mapaRomanos= new HashMap<>(){{
            put(1000,"M");
            put(500,"D");
            put(100,"C");
            put(50,"L");
            put(10,"X");
            put(5,"V");
            put(1,"I");
    }};

    public static String agregarCXI(String romano, Integer contador, String letra){
        String compuesto4;
        switch (letra){
            case "C":compuesto4="CD";
            break;
            case "X":compuesto4="XL";
            break;
            case "I":compuesto4="IV";
            break;
            default:compuesto4="";
        }
        romano = (contador==4) ? romano+compuesto4 : romano + letra.repeat(contador);
        return romano;
    }

    private static int contar(Integer numero, Integer valor){
        int contador =0;
        while (numero-valor>=0){
            numero-=valor;
            contador++;
        }
        return contador;
    }

    public static String convertirARomano(Integer numero){
        String romano="";
        int contador;
        if (numero<3999){
            while(numero-1000>=0){
                romano+="M";
                numero-=1000;
            }

            if(numero-500>=0) {
                numero -=500;
                romano +="D";
            }

            contador= contar(numero, 100);
            if(contador>0){
                numero-=(contador*100);
                romano=agregarCXI(romano,contador,"C");
            }

            if(numero-50>=0){
                numero-=50;
                romano +="L";
            }

            contador=  contar(numero, 10);
            if (contador>0){
                numero-=(contador*10);
                romano=agregarCXI(romano,contador,"X");
            }

            if(numero-5>=0){
                numero-=5;
                romano+="V";
            }

            contador= contar(numero, 1);
            if(contador>0){
                numero-=(contador*1);
                romano=agregarCXI(romano,contador,"I");
            }
        }
        else{
            romano="No se pudo convertir";
        }
        return romano;
    }
}
