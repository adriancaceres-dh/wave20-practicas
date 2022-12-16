package com.bootcamp;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Persona anon = new Persona();
        Persona harry = new Persona("Harry", 46, "AR-437102");
        Persona marv = new Persona("Marv", 44, "AR-462940", 71, 186);

        // Imprimo por consola datos de Marv
        System.out.println("INFORMACIÓN DE MARV:");
        System.out.println("Datos personales:");
        System.out.println(marv.toString());
        System.out.println("Categoría: " + (marv.esMayorDeEdad() ? "Adulto" : "Menor"));
        System.out.println("IMC: " + (marv.calcularIMC() == -1 ? "Bajo Peso" : (marv.calcularIMC() == 0 ? "Peso saludable" : "Sobrepeso")));
    }
}