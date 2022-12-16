package com.bootcamp.poo;

public class Main {
    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaNombreDniEdad = new Persona("Pedro", "123546",16);
        Persona personaConstructorCompleto = new Persona("Camilo", "456789", 28, 1.65f,75);
        /* No se puede crear un objeto de una clase sin cumplir con los constructores por lo que
           Persona persona = new Persona("Nombre"); dará un error e igual con edad
           Persona persona = new Persona("Nombre",28);
        */
        int resultadoImc = personaConstructorCompleto.calcularIMC();
        switch (resultadoImc){
            case(-1):
                System.out.println(personaConstructorCompleto.nombre+" tiene Bajo peso");
                break;
            case (0):
                System.out.println(personaConstructorCompleto.nombre+" tiene Peso saludable");
                break;
            case (1):
                System.out.println(personaConstructorCompleto.nombre+" tiene Sobre peso");
                break;
            default:
                System.out.println("Error en el calculo de IMC, por favor revise valores");
                break;
        }
        String mayorEdad = (personaConstructorCompleto.mayordeEdad())?"Mayor de edad":"Menor de edad";
        System.out.println(personaConstructorCompleto.nombre+" es "+mayorEdad);
        System.out.println("metodo toString "+ personaConstructorCompleto);

    }
}
