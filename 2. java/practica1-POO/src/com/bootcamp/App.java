package com.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Map<Integer,String> nivelesDePeso= new HashMap<>();
        nivelesDePeso.put(-1,"Bajo peso");
        nivelesDePeso.put(0,"Peso saludable");
        nivelesDePeso.put(1,"Sobrepeso");


        Persona personaSinParametros = new Persona();
        Persona personaCon3Parameteros = new Persona ("Emiliano",25,"63565655");
        Persona personaCon5Parametros = new Persona("Emiliano",25,"24234234",75,1.75);

        System.out.println("Datos de la persona: "+personaCon5Parametros.toString());

        System.out.println("IMC: "+nivelesDePeso.get(personaCon5Parametros.calcularIMC()));
        if (personaCon5Parametros.esMayorDeEdad()){
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("No es mayor de edad.");
        }
    }


}
