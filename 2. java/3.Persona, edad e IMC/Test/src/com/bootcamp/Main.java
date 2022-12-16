package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona personaConstructor = new Persona();
        Persona persona3Parametros = new Persona("Nathalia", 17, "123456N");
        Persona personaInfoCompleta = new Persona("Marcela", 26, "1246756M", 62, 1.70);
        System.out.println(personaInfoCompleta.toString());
        System.out.println(personaInfoCompleta.esMayorDeEdad());
        System.out.println(personaInfoCompleta.cacularIMC());
    }
}