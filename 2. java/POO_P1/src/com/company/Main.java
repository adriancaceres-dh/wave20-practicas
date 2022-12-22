package com.company;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carolina", 40,"4566738" );
        Persona persona3 = new Persona("Andres", 20, "2122393483", 50, 1.70);

        System.out.println("IMC: " + persona3.calcularIMC());
        System.out.println(persona3.getNombre() + ", Tiene la mayoria de edad?: " + persona3.esMayorDeEdad());
        System.out.println("Información Personal: \n" + persona3);

        }
    }
