package com.poo;

import java.util.MissingFormatArgumentException;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    int altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public Persona(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC() {

        double IMC = this.peso/(Math.pow(this.altura/100, 2));
        if (IMC < 20) return -1;
        else if (IMC <= 25) return 0;
        return 1;
    }

    public Boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "/" +
                "Edad: " + this.edad + "/" +
                "Dni: " + this.dni + "/" +
                "Peso: " + this.peso + "/" +
                "Altura: " + this.altura;
    }
}
