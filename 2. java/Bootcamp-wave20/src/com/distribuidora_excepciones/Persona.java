package com.distribuidora_excepciones;

public class Persona {

    private String name;
    private int edad;
    private String dni;
    private double altura;
    private double peso;


    public Persona() {

    }

    public Persona(String name, int edad, String dni) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String name, int edad, String dni, double altura, double peso) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = 0;
        try {
            imc = this.peso / Math.pow(this.altura, 2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
