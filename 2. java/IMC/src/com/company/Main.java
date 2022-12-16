package com.company;

import com.company.model.Persona;

public class Main {

    public static void main(String[] args) {


        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan Carlos",24,"1064121");
        Persona persona3 = new Persona("Ronal", 20, "100000",  72.29f, 172.6f);


        System.out.println("El IMC de "+persona3.getNombre()+" es de: "+persona3.calcularIMC());

        String esMayor = persona3.getNombre() + (persona3.esMayorDeEdad() ? " es mayor de edad": " es menor de edad");

        System.out.println(esMayor);

        System.out.println(persona3.toString());


    }
}
