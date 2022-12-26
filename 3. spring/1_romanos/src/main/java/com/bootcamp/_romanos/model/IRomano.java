package com.bootcamp._romanos.model;

import java.util.Map;
import java.util.TreeMap;

public interface IRomano {

    final static TreeMap<Integer, String> mapaRomanos= new TreeMap<>(){{
        put(1000,"M");
        put(900,"CM");
        put(500,"D");
        put(400,"CD");
        put(100,"C");
        put(90,"XC");
        put(50,"L");
        put(40,"XL");
        put(10,"X");
        put(9,"IX");
        put(5,"V");
        put(4,"IV");
        put(1,"I");
    }};

}
