package paquete;
import java.lang.Math;
public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

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

    public int calculaIMC(){
        double valorIMC;
        valorIMC = peso / altura*altura;
        if ( valorIMC<20){
            return -1;
        }
        if ( valorIMC>=20&&valorIMC<=25){
            return 0;
        }
        else {
            return 1;
        }

    }

    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad > 18) {
            mayor = true;
        }
        return mayor;
    }

    public String toString(){
        return "nombre: "+nombre+" edad: " + String.valueOf(edad) +" cedula: "+ dni + " peso: "+ String.valueOf(peso) + " Altura: "+String.valueOf(altura);
    }
}

