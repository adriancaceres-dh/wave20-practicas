package com.company.model;

public class Persona {
    String Nombre;
    int Edad;
    String Dni;
    float Peso;
    float Altura;


    public float calcularIMC(){
        float resultado = 0;
        try {

            resultado = (float) (Peso/Math.pow(Altura, 2)) - (Peso + Altura);

            if(resultado < 20){
                resultado = -1;
            }

            if(resultado <= 20 && resultado >= 25){
                resultado = 0;
            }

            if(resultado > 25){
                resultado = 1;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    public boolean esMayorDeEdad(){
        if(Edad < 18){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                ", Dni='" + Dni + '\'' +
                ", Peso=" + Peso +
                ", Altura=" + Altura +
                '}';
    }

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        Nombre = nombre;
        Edad = edad;
        Dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        Nombre = nombre;
        Edad = edad;
        Dni = dni;
        Peso = peso;
        Altura = altura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        this.Peso = peso;
    }

    public float getAltura() {
        return Altura;
    }

    public void setAltura(float altura) {
        this.Altura = altura;
    }
}
