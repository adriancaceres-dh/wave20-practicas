package com.bootcamp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona anon = new Persona();
        Persona harry = new Persona("Harry", 46, "AR-437102");
        Persona marv = new Persona("Marv", 44, "AR-462940", 71, 186);

        /*
        Imprimo por consola datos de Marv
        System.out.println("INFORMACIÓN DE MARV:");
        System.out.println("Datos personales:");
        System.out.println(marv.toString());
        System.out.println("Categoría: " + (marv.esMayorDeEdad() ? "Adulto" : "Menor"));
        System.out.println("IMC: " + (marv.calcularIMC() == -1 ? "Bajo Peso" : (marv.calcularIMC() == 0 ? "Peso saludable" : "Sobrepeso")));
        */

        System.out.println("Ingrese su nombre: ");
        String nombre = new Scanner(System.in).next();
        System.out.println("Ingrese su peso en kg: ");
        double peso = new Scanner(System.in).nextDouble();
        System.out.println("Ingrese su altura en cm: ");
        double altura = new Scanner(System.in).nextDouble();
        System.out.println("");

        Persona user = new Persona(nombre, peso, altura);
        System.out.println(String.format("IMC: %.2f", user.calculateIMC()));
        int imc = user.calcularIMC();
        String cat = imc == -1 ? "Bajo Peso" : (imc == 0 ? "Peso saludable" : "Sobrepeso");
        System.out.println("Clasificación: "+ cat);
    }
}