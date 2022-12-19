package com.bootcamp;

public class Persona {
    String nombre, dni;
    int edad;
    float peso, altura;

    public Persona(){

    }
    public Persona (String nombre, String dni, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona (String nombre, String dni, int edad, float peso, float altura){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC(){
        double imc =   (this.peso / (this.altura*this.altura));

        if (imc < 20) return -1;
        if (imc >= 20 && imc <= 25) return 0;

        return 1;
    }

    public boolean esMayorDeEdad(){
        if (this.edad >= 18) return true;

        return false;
    }

    @Override
    public String toString(){
        return "Nombre: "+this.nombre+", dni: "+this.dni+", edad: "+this.edad+", peso: "+this.peso+", altura: "+this.altura;
    }
}
