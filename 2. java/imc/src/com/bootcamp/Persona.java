package com.bootcamp;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso; // kilogramos
    double altura; // metros

    public Persona() { }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = (this.peso / Math.pow(altura, 2));
        return imc < 20 ? -1 : (imc <= 25 ? 0 : 1);
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona { " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso + "kg" +
                ", altura=" + altura + "m " +
                '}';
    }
}
