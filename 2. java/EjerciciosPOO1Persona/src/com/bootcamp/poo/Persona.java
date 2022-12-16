package com.bootcamp.poo;

public class Persona {
    String nombre;
    String dni;
    float alturaMts;
    int edad;
    int pesoKgs;

    public Persona(){

    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, float alturaMts, int pesoKgs) {
        this(nombre, dni, edad);
        this.alturaMts = alturaMts;
        this.edad = edad;
        this.pesoKgs = pesoKgs;
    }

    public int calcularIMC(){
        try {
            double imc = pesoKgs /(Math.pow(alturaMts,2));
            System.out.println("imc = " + imc);
            if (imc <20){
                return -1;
            } else if (imc >= 20 && imc <=25) {
                return 0;
            }
            else {
                return 1;
            }
        }
        catch (ArithmeticException e){
            System.out.println("Error "+e+" La altura debe ser diferente de 0");
            return -2;
        }
    }

    public boolean mayordeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return nombre+" identificado con "+dni
                +", con altura "+ alturaMts
                + ", en metros, con edad "+edad
                +" y peso "+ pesoKgs
                +" en Kgs";
    }
}
