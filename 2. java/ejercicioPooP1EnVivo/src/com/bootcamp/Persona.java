package com.bootcamp;

public class Persona {
    private String nombre, dni;
    private int edad;
    private double altura, peso;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double altura, double peso) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int calcularIMC() {
        double imc;
        imc = peso/(Math.pow(altura,2));
        if (imc < 20) return -1;
        else if (imc > 25) return 1;
        else return 0;
    }

    public boolean esMayorDeEdad() {
        if (edad >= 18) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Persona{ " +
                "nombre= '" + nombre + '\'' +
                ", dni= '" + dni + '\'' +
                ", edad= " + edad +
                ", altura= " + altura +
                ", peso= " + peso +
                " }";
    }
}
