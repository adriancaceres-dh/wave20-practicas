package com.bootcamp;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;


    public Persona(){

    }

    public Persona (String nombre , int edad , String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona (String nombre , int edad , String dni , int peso , double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean esMayorDeEdad(){
        return getEdad() > 18;
    }

    public int calcularIMC(){
        double IMC = (getPeso()/Math.pow(getAltura(),2));
        if (IMC < 20){
            return -1;
        } else {
            if (IMC >= 20 && IMC <= 25){
                return 0;
            }
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
