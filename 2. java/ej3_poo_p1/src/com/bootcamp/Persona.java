package com.bootcamp;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        this.peso=peso;
        this.altura=altura;
    }

    public int calcularIMC(){
        try{
            double IMC= (this.peso/Math.pow(this.altura,2));
            if(IMC<20){
                return -1;
            }
            else if(IMC<=25){
                return 0;
            }
            else{
                return 1;
            }
        } catch (Exception e){
            return -2;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
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
