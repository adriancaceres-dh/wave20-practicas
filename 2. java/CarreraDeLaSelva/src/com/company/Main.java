package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> persona = new HashMap<String, String>();

        try {

        }catch (NullPointerException e ){
            System.out.println(e.getMessage());
        }
        persona.put("DNI", "1064121751");
        persona.put("Nombre", "Juan Carlos");
        persona.put("Apellido", "Ortiz Reales");
        persona.put("Edad", "24");
        persona.put("Celular", "3208201482");

        for (String key : persona.keySet()){
            System.out.println(key + "=> " + persona.get(key));
        }



        
    }
}
