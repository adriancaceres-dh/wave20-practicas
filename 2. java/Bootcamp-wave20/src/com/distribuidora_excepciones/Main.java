package com.distribuidora_excepciones;

public class Main {

    public static void main(String[] args) {
        String indiceMasaCorporal = "El indice de masa corporal o el nivel de peso de la persona es: ";
        String mayorDeEdad = "La persona es mayor de edad.";
        String menorDeEdad = "La persona es menor de edad.";

        Persona personaSinAtributos = new Persona();
        Persona personaIncompleta = new Persona("karen", 32, "34768987");
        Persona personaCompleta = new Persona("kar", 32, "38768987", 1.56, 60D);

        int imc = personaCompleta.calcularIMC();
        boolean mayor = personaCompleta.esMayorDeEdad();
        System.out.println(indiceMasaCorporal);
        if (imc == -1) System.out.println("bajo");

        if (imc == 0) System.out.println("saludable");

        if (imc == 1) System.out.println("alto");

        if (mayor) {
            System.out.println(mayorDeEdad);
        } else {
            System.out.println(menorDeEdad);
        }












    }
}
