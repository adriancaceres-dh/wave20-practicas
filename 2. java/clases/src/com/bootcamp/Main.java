package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona persona1=new Persona();
        Persona persona2=new Persona("david",20,"122434");
        Persona persona3=new Persona("david",20,"122434",65.4f,1.81f);

        int imc=persona3.calcularIMC();
        boolean esMayor=persona3.esMayorDeEdad();

        if (imc==-1){
            System.out.println("Bajo peso");
        } else if (imc==0) {
            System.out.println("Peso saludable");
        }else System.out.println("Sobre peso");

        System.out.println("Es mayor de edad?"+esMayor);
        System.out.println(persona3);
    }

}
