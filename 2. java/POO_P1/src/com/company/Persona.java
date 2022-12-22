package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //Constructor de la clase

    public Persona() {
    }

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

    public String getNombre() {
        return nombre;
    }

    public int calcularIMC(){
       double calculo = peso / Math.pow(altura, 2);
        if (calculo < 20) {
            return -1;
       }
        if (calculo <= 25) {
            return 0;
       }
        return 1;
    }

    public boolean esMayorDeEdad(){
            return edad >= 18;
    }

    public String toString(){
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
        }
    }
