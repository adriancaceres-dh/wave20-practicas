package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos",73,"2764367");
        Persona persona3 = new Persona("Lucia", 33,"87346583", 70.3,1.60);

        int IMC= persona3.calcularIMC();
        switch (IMC){
            case -1:System.out.println("Bajo peso");
                break;
            case 0:System.out.println("Peso saludable");
                break;
            case 1:System.out.println("Sobrepeso");
                break;
            default:System.out.println("Error");
                break;
        }

        boolean mayor=persona3.esMayorDeEdad();
        if(mayor) { System.out.println("Es mayor de edad");}
        else {System.out.println("Es menor de edadd");}

        System.out.println(persona3.toString());
    }
}
